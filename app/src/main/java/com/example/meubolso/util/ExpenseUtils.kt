package com.example.meubolso.util

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object ExpenseUtils {

    private val ptBrLocale = Locale.Builder()
        .setLanguage("pt")
        .setRegion("BR")
        .build()

    /**
     * Converte um valor em centavos para a string formatada em Reais (R$).
     */
    fun formatCurrency(cents: Long): String {
        val decimalValue = BigDecimal.valueOf(cents, 2)
        val format = NumberFormat.getCurrencyInstance(ptBrLocale)
        return format.format(decimalValue)
    }

    /**
     * Converte uma string de valor digitada pelo usuário (ex: "45,90", "1.250,50", "15")
     * em centavos (Long). Retorna null caso o valor seja inválido ou menor/igual a zero.
     */
    fun parseAmountToCents(amountText: String): Long? {
        val trimmed = amountText.trim()
        if (trimmed.isEmpty()) return null

        // Remove pontos de milhar e substitui vírgula decimal por ponto
        val cleanInput = if (trimmed.contains(",")) {
            trimmed.replace(".", "").replace(",", ".")
        } else {
            trimmed
        }

        val bigDecimal = cleanInput.toBigDecimalOrNull() ?: return null

        if (bigDecimal <= BigDecimal.ZERO) return null

        // Limita a até 2 casas decimais
        if (bigDecimal.scale() > 2) return null

        return try {
            bigDecimal
                .movePointRight(2)
                .setScale(0, RoundingMode.UNNECESSARY)
                .longValueExact()
        } catch (_: ArithmeticException) {
            null
        }
    }

    /**
     * Formata um timestamp em data e hora legíveis em português (pt-BR).
     */
    fun formatDate(timestampMillis: Long): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", ptBrLocale)
        return sdf.format(Date(timestampMillis))
    }
}
