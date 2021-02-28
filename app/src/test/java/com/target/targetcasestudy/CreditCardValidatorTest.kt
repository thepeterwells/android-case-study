package com.target.targetcasestudy

import com.target.targetcasestudy.data.validateCreditCard
import org.junit.Assert
import org.junit.Test

/**
 * Feel free to make modifications to these unit tests! Remember, you have full technical control
 * over the project, so you can use any libraries and testing strategies that see fit.
 */
class CreditCardValidatorTest {
  @Test
  fun `is credit card number valid`() {
    Assert.assertTrue(
      "valid credit card number should yield true",
      validateCreditCard("4539976741512043")
    )
  }

  @Test
  fun `is credit card number invalid`() {
    Assert.assertFalse(
      "invalid credit card number should yield false",
      validateCreditCard("4539976741512046")
    )
    Assert.assertFalse(
      "card number under 13 digits should yield false",
      validateCreditCard("14325673")
    )
    Assert.assertFalse(
      "card number over 19 digits should yield false",
      validateCreditCard("849232848358374343564")
    )
  }
}
