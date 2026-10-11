package com.example.meubolso.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.meubolso.data.Expense
import com.example.meubolso.data.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExpenseViewModel(
    private val repository: ExpenseRepository
) : ViewModel() {

    // Filtro por categoria (null = Todas)
    val selectedCategory = MutableStateFlow<String?>(null)

    val expenses: StateFlow<List<Expense>> =
        repository.allExpenses.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val filteredExpenses: StateFlow<List<Expense>> =
        combine(expenses, selectedCategory) { list, category ->
            if (category == null || category == "Todas") {
                list
            } else {
                list.filter { it.category.equals(category, ignoreCase = true) }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun setCategoryFilter(category: String?) {
        selectedCategory.value = category
    }

    fun getExpenseById(id: Long): Flow<Expense?> {
        return repository.getExpenseById(id)
    }

    fun addExpense(
        description: String,
        amountCents: Long,
        category: String
    ) {
        viewModelScope.launch {
            repository.insert(
                Expense(
                    description = description.trim(),
                    amountCents = amountCents,
                    category = category.trim()
                )
            )
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            repository.delete(expense)
        }
    }

    fun deleteExpenseById(id: Long) {
        viewModelScope.launch {
            repository.deleteById(id)
        }
    }
}

class ExpenseViewModelFactory(
    private val repository: ExpenseRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(ExpenseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExpenseViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "ViewModel desconhecido: ${modelClass.name}"
        )
    }
}
