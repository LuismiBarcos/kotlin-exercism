package com.exercism.roman.numerals

object RomanNumerals {
    private val romanNumeralMap = linkedMapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    fun value(n: Int): String {
        require(n in 1..3000) { "Number must be in the range 1 to 3000" }

        var num = n
        var romanNumeral = ""

        for ((value, symbol) in romanNumeralMap) {
            while (num >= value) {
                romanNumeral += symbol
                num -= value
            }
        }

        return romanNumeral
    }
}
