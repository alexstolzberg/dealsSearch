package com.target.targetcasestudy.data

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidatorsTest {

    @Test
    fun `input has letters`() {
        val isCreditCardValid = validateCreditCard("1234abcd5678")
        assertFalse(isCreditCardValid)
    }

    @Test
    fun `credit card input length is too short`() {
        val isCreditCardValid = validateCreditCard("1234")
        assertFalse(isCreditCardValid)
    }

    @Test
    fun `credit card input length is too long`() {
        val isCreditCardValid = validateCreditCard("11112222333344445555") // 20 digits
        assertFalse(isCreditCardValid)
    }

    @Test
    fun `credit card with correct length invalid last digit`() {
        INVALID_CREDIT_CARDS.forEach {
            val isCreditCardValid = validateCreditCard(it)
            assertFalse(isCreditCardValid)
        }
    }

    @Test
    fun `credit card correct length valid input`() {
        VALID_CREDIT_CARDS.forEach {
            val isCreditCardValid = validateCreditCard(it)
            assertTrue(isCreditCardValid)
        }
    }

    companion object {
        private val VALID_CREDIT_CARDS = listOf(
            "4556737586899855",
            "4532857322115264",
            "6011182821842879",
            "6011387125402583818",
            "30538253313525",
            "4026235055963452",
            "2221004897325677",
            "3529185877561145882",
            "36685922334004",
            "6395951157646948",
            "370798671386341",
            "5531339416202231",
            "5020212475301392"
        )

        private val INVALID_CREDIT_CARDS = listOf( // last digits are wrong
            "4556737586899856",
            "4532857322115265",
            "6011182821842878",
            "6011387125402583817",
            "30538253313524",
            "4026235055963451",
            "2221004897325679",
            "3529185877561145886",
            "36685922334006",
            "6395951157646944",
            "370798671386342",
            "5531339416202237",
            "5020212475301394"
        )

    }
}