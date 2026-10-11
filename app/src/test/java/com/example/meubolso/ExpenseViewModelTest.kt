package com.example.meubolso

import com.example.meubolso.data.Expense
import com.example.meubolso.data.ExpenseDao
import com.example.meubolso.data.ExpenseRepository
import com.example.meubolso.viewmodel.ExpenseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ExpenseViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    private class FakeExpenseDao : ExpenseDao {
        private val expensesFlow = MutableStateFlow<List<Expense>>(emptyList())

        override fun getAllExpenses(): Flow<List<Expense>> = expensesFlow

        override fun getExpenseById(id: Long): Flow<Expense?> =
            expensesFlow.map { list -> list.find { it.id == id } }

        override suspend fun insertExpense(expense: Expense) {
            val current = expensesFlow.value.toMutableList()
            val newId = if (expense.id == 0L) (current.maxOfOrNull { it.id } ?: 0L) + 1L else expense.id
            current.add(0, expense.copy(id = newId))
            expensesFlow.value = current
        }

        override suspend fun deleteExpense(expense: Expense) {
            val current = expensesFlow.value.toMutableList()
            current.removeAll { it.id == expense.id }
            expensesFlow.value = current
        }

        override suspend fun deleteExpenseById(id: Long) {
            val current = expensesFlow.value.toMutableList()
            current.removeAll { it.id == id }
            expensesFlow.value = current
        }
    }

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun categoryFilter_filtersExpensesCorrectly() = runTest {
        val fakeDao = FakeExpenseDao()
        val repository = ExpenseRepository(fakeDao)
        val viewModel = ExpenseViewModel(repository)

        fakeDao.insertExpense(Expense(id = 1, description = "Almoço", amountCents = 3000, category = "Alimentação"))
        fakeDao.insertExpense(Expense(id = 2, description = "Ônibus", amountCents = 500, category = "Transporte"))
        fakeDao.insertExpense(Expense(id = 3, description = "Jantar", amountCents = 4500, category = "Alimentação"))

        // Inicialmente sem filtro ("Todas")
        assertEquals(3, viewModel.expenses.first().size)
        assertEquals(3, viewModel.filteredExpenses.first().size)

        // Filtra por Alimentação
        viewModel.setCategoryFilter("Alimentação")
        val filtered = viewModel.filteredExpenses.first()
        assertEquals(2, filtered.size)
        assertEquals("Alimentação", filtered[0].category)
        assertEquals("Alimentação", filtered[1].category)

        // Filtra por Transporte
        viewModel.setCategoryFilter("Transporte")
        assertEquals(1, viewModel.filteredExpenses.first().size)
    }

    @Test
    fun addExpense_and_deleteExpense_updatesState() = runTest {
        val fakeDao = FakeExpenseDao()
        val repository = ExpenseRepository(fakeDao)
        val viewModel = ExpenseViewModel(repository)

        viewModel.addExpense("Cinema", 2500, "Lazer")
        assertEquals(1, viewModel.expenses.first().size)

        val added = viewModel.expenses.first().first()
        assertEquals("Cinema", added.description)

        viewModel.deleteExpense(added)
        assertEquals(0, viewModel.expenses.first().size)
    }
}
