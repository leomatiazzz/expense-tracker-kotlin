package com.example.meubolso

import com.example.meubolso.util.ExpenseUtils
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExpenseUtilsTest {

    @Test
    fun parseAmountToCents_validInputs() {
        // Valida entradas em formato brasileiro com vírgula
        assertEquals(4590L, ExpenseUtils.parseAmountToCents("45,90"))
        assertEquals(125050L, ExpenseUtils.parseAmountToCents("1.250,50"))
        assertEquals(1000L, ExpenseUtils.parseAmountToCents("10,00"))
        assertEquals(5000L, ExpenseUtils.parseAmountToCents("50"))

        // Valida entrada com ponto decimal
        assertEquals(2590L, ExpenseUtils.parseAmountToCents("25.90"))
    }

    @Test
    fun parseAmountToCents_invalidInputs() {
        // Valida que valores vazios, zerados, negativos ou mal formatados retornam null
        assertNull(ExpenseUtils.parseAmountToCents(""))
        assertNull(ExpenseUtils.parseAmountToCents("   "))
        assertNull(ExpenseUtils.parseAmountToCents("0"))
        assertNull(ExpenseUtils.parseAmountToCents("0,00"))
        assertNull(ExpenseUtils.parseAmountToCents("-50,00"))
        assertNull(ExpenseUtils.parseAmountToCents("abc"))
        assertNull(ExpenseUtils.parseAmountToCents("10,505")) // Mais de 2 casas decimais
    }

    @Test
    fun formatCurrency_formatsCorrectly() {
        val formatted = ExpenseUtils.formatCurrency(4590L)
        // Deve conter R$ e o valor 45,90
        assertTrue(formatted.contains("45,90"))
        assertTrue(formatted.contains("R$"))
    }

    @Test
    fun formatDate_returnsNonEmptyString() {
        val formattedDate = ExpenseUtils.formatDate(System.currentTimeMillis())
        assertTrue(formattedDate.isNotEmpty())
        assertTrue(formattedDate.contains("/"))
    }
}
