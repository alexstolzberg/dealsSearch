package com.target.targetcasestudy.data

/**
 * For an explanation of how to validate credit card numbers read:
 *
 * https://www.freeformatter.com/credit-card-number-generator-validator.html#fakeNumbers
 *
 * This contains a breakdown of how this algorithm should work as
 * well as a way to generate fake credit card numbers for testing
 *
 * The structure and signature of this is open to modification, however
 * it *must* include a method, field, etc that returns a [Boolean]
 * indicating if the input is valid or not
 *
 * Additional notes:
 *  * This method does not need to validate the credit card issuer
 *  * This method must validate card number length (13 - 19 digits), but does not
 *    need to validate the length based on the issuer.
 *
 * @param creditCardNumber - credit card number of (13, 19) digits
 * @return true if a credit card number is believed to be valid,
 * otherwise false
 */
fun validateCreditCard(creditCardNumber: String): Boolean {
    // Verify that input is digits only
    // TODO: Would have used isDigitsOnly() but it was causing issues with tests
    val hasNonDigits = creditCardNumber.any { !DIGITS_LIST.contains(it) }
    if (hasNonDigits) {
        return false
    }

    // Verify that input is the correct length
    if (creditCardNumber.length < CC_MIN_LENGTH || creditCardNumber.length > CC_MAX_LENGTH) {
        return false
    }

    // Extract numbers from the inout string
    val creditCardDigits = creditCardNumber
        .chunked(1)
        .map { it.toInt() }
        .toMutableList()

    // Drop the last number
    val lastDigit = creditCardDigits.last()
    creditCardDigits.removeLast()

    // Reverse the digits
    val reversedDigits = creditCardDigits.reversed()

    // Multiply odd digits by 2
    val oddsDoubledDigits = mutableListOf<Int>()
    reversedDigits.forEachIndexed { index, i ->
        val newDigit = if (index % 2 == 0) i * 2 else i
        oddsDoubledDigits.add(newDigit)
    }

    // Subtract any digit >9 by 9
    val subtractedDigits = oddsDoubledDigits.map { if (it > 9) it - 9 else it }

    // Sum all digits
    val digitsSum = subtractedDigits.sum()

    // Multiply by 9
    // Note: This step was missing from the link above
    val multipliedBy9 = digitsSum * 9

    // Modulo 10
    val digitSumMod10 = multipliedBy9 % 10

    // Check if this value is equal to the last digit of the original card number
    return digitSumMod10 == lastDigit
}

private const val CC_MIN_LENGTH = 13
private const val CC_MAX_LENGTH = 19
private val DIGITS_LIST = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')