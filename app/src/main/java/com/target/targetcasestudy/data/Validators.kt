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
    if (creditCardNumber.length < 13 || creditCardNumber.length > 19) {
        return false
    }
    val digits = ArrayList<Int>()
    creditCardNumber.forEach { digits.add(it.toString().toInt()) }
    val lastDigit = digits.removeLast()
    digits.reverse()
    digits.indices.forEach {
        if ((it + 1) % 2 == 1) {
            digits[it] = digits[it] * 2
        }
        if (digits[it] > 9) {
            digits[it] = digits[it] - 9
        }
    }
    return digits.sum() % 10 == (10 - lastDigit)
}