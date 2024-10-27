package ru.netology

import kotlin.math.max

fun main() {

    calculateCommission(150000, "Mastercard", 50000)

}

fun calculateCommission(amount: Int, cardType: String = "Мир", monthAmount: Int = 0): Double {
    val limit = 150000
    val monthLimit = 650000

    if (amount > limit) {
        println("Превышение суточного лимита")
        return -1.0
    }

    if (monthAmount + amount > monthLimit) {
        println("Превышение месячного лимита")
        return -1.0
    }

    val commission: Double =
        when (cardType) {
            "Mastercard" -> mastercardCommission(amount, monthAmount)
            "Visa" -> visaCommission(amount)
            "Мир" -> 0.0
            else -> {
                println("Некорректный тип карты")
                return -1.0
            }
        }

    return commission
}

fun visaCommission(amount: Int): Double {
    val percent = 0.75
    val minCommission = 35

    return max(minCommission.toDouble(), amount / 100 * percent)
}

fun mastercardCommission(amount: Int, monthAmount: Int): Double {
    val limit = 75000
    val percent = 0.6
    val baseCommission = 20

    val currentLimit = if (limit - monthAmount < 0) 0 else limit - monthAmount

    var commission = 0.0

    if (amount > currentLimit) {
        commission = (amount - currentLimit) * percent / 100 + baseCommission
    }

    return commission
}