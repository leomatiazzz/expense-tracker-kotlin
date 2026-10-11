package com.example.meubolso

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.meubolso.data.Expense
import com.example.meubolso.data.ExpenseDao
import com.example.meubolso.data.ExpenseDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExpenseDaoTest {

    private lateinit var database: ExpenseDatabase
    private lateinit var expenseDao: ExpenseDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, ExpenseDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        expenseDao = database.expenseDao()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun insertAndGetExpenseById() = runBlocking {
        val expense = Expense(
            description = "Mercado",
            amountCents = 15050,
            category = "Alimentação"
        )
        expenseDao.insertExpense(expense)

        val list = expenseDao.getAllExpenses().first()
        assertEquals(1, list.size)

        val inserted = list.first()
        val fetched = expenseDao.getExpenseById(inserted.id).first()
        assertEquals("Mercado", fetched?.description)
        assertEquals(15050L, fetched?.amountCents)
    }

    @Test
    fun deleteExpense_removesFromDb() = runBlocking {
        val expense = Expense(
            id = 10,
            description = "Farmácia",
            amountCents = 4500,
            category = "Saúde"
        )
        expenseDao.insertExpense(expense)

        val beforeDelete = expenseDao.getExpenseById(10).first()
        assertEquals("Farmácia", beforeDelete?.description)

        expenseDao.deleteExpense(expense)

        val afterDelete = expenseDao.getExpenseById(10).first()
        assertNull(afterDelete)
    }
}
