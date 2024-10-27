package ru.netology

import org.junit.Test

import org.junit.Assert.*

@Suppress("DEPRECATION")
class MainKtTest {

    val delta = 0.001

    @Test
    fun calculateBadType() {

        val type = "SomeType"
        val amount = 10000
        val result = calculateCommission(amount, type)
        assertEquals(result, -1.0, delta)

    }

    @Test
    fun calculateDefault() {

        val amount = 10000
        val result = calculateCommission(amount)
        assertEquals(result, 0.0, delta)

    }

    @Test
    fun calculateOverMonthLimit() {

        val type = "Мир"
        val amount = 10000
        val monthAmount = 650000
        val result = calculateCommission(amount, type, monthAmount)
        assertEquals(result, -1.0, delta)

    }

    @Test
    fun calculateOverDayLimit() {

        val type = "Мир"
        val amount = 151000
        val monthAmount = 0
        val result = calculateCommission(amount, type, monthAmount)
        assertEquals(result, -1.0, delta)

    }

    @Test
    fun calculateVisaMinCommission() {

        val type = "Visa"
        val amount = 100
        val monthAmount = 0
        val result = calculateCommission(amount, type, monthAmount)
        assertEquals(result, 35.0, delta)

    }

    @Test
    fun calculateVisaCommission() {

        val type = "Visa"
        val amount = 10000
        val monthAmount = 0
        val result = calculateCommission(amount, type, monthAmount)
        assertEquals(result, 75.0, delta)

    }

    @Test
    fun calculateMastercardCommission() {

        val type = "Mastercard"
        val amount = 150000
        val monthAmount = 0
        val result = calculateCommission(amount, type, monthAmount)
        assertEquals(result, 470.0, delta)

    }

    @Test
    fun calculateMastercardCommissionOverLimit() {

        val type = "Mastercard"
        val amount = 100
        val monthAmount = 75000
        val result = calculateCommission(amount, type, monthAmount)
        assertEquals(result, 20.6, delta)

    }
}