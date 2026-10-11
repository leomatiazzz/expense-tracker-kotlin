package com.example.meubolso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meubolso.data.ExpenseDatabase
import com.example.meubolso.data.ExpenseRepository
import com.example.meubolso.ui.theme.MeuBolsoApp
import com.example.meubolso.ui.theme.theme.MeuBolsoTheme
import com.example.meubolso.viewmodel.ExpenseViewModel
import com.example.meubolso.viewmodel.ExpenseViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = ExpenseDatabase.getDatabase(
            applicationContext
        )

        val repository = ExpenseRepository(
            database.expenseDao()
        )

        setContent {
            val factory = remember {
                ExpenseViewModelFactory(repository)
            }

            val expenseViewModel: ExpenseViewModel =
                viewModel(factory = factory)

            MeuBolsoTheme {
                Surface {
                    MeuBolsoApp(
                        viewModel = expenseViewModel
                    )
                }
            }
        }
    }
}
