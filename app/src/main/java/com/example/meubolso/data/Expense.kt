package com.example.meubolso.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val description: String,
    val amountCents: Long,
    val category: String,
    val createdAt: Long = System.currentTimeMillis()
)