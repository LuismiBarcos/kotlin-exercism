package com.exercism.difference.of.squares

import java.util.stream.IntStream
import kotlin.math.pow

class Squares(private val number: Int) {

    fun sumOfSquares(): Int =
        IntStream.rangeClosed(1, number)
            .map { it.toDouble().pow(2.0).toInt() }
            .sum()

    fun squareOfSum(): Int {
        return IntStream.rangeClosed(1, number)
            .sum()
            .toDouble()
            .pow(2.0)
            .toInt()
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}