package com.example.meubolso.data

import kotlinx.coroutines.flow.Flow

class ExpenseRepository(
    private val expenseDao: ExpenseDao
) {
    val allExpenses: Flow<List<Expense>> =
        expenseDao.getAllExpenses()

    fun getExpenseById(id: Long): Flow<Expense?> {
        return expenseDao.getExpenseById(id)
    }

    suspend fun insert(expense: Expense) {
        expenseDao.insertExpense(expense)
    }

    suspend fun delete(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }

    suspend fun deleteById(id: Long) {
        expenseDao.deleteExpenseById(id)
    }
}
