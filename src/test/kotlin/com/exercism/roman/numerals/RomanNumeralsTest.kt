package com.exercism.roman.numerals

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class RomanNumeralsTest {

    companion object {
        @JvmStatic
        fun data() = listOf(
            arrayOf(1, "I"),
            arrayOf(2, "II"),
            arrayOf(3, "III"),
            arrayOf(4, "IV"),
            arrayOf(5, "V"),
            arrayOf(6, "VI"),
            arrayOf(9, "IX"),
            arrayOf(27, "XXVII"),
            arrayOf(48, "XLVIII"),
            arrayOf(49, "XLIX"),
            arrayOf(59, "LIX"),
            arrayOf(93, "XCIII"),
            arrayOf(141, "CXLI"),
            arrayOf(163, "CLXIII"),
            arrayOf(402, "CDII"),
            arrayOf(575, "DLXXV"),
            arrayOf(911, "CMXI"),
            arrayOf(1024, "MXXIV"),
            arrayOf(3000, "MMM")
        )
    }

    @ParameterizedTest
    @MethodSource("data")
    fun test(input: Int, expectedOutput: String) {
        assertEquals(expectedOutput, RomanNumerals.value(input))
    }
}