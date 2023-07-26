package com.exercism.twofer

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TwoFerTest {

    @Test
    fun noNameGiven() {
        val twoFer = TwoFer()

        assertEquals("One for you, one for me.", twoFer.twofer())
    }

    @Test
    fun aNameGiven() {
        val twoFer = TwoFer()

        assertEquals("One for Alice, one for me.", twoFer.twofer("Alice"))
    }

    @Test
    fun anotherNameGiven() {
        val twoFer = TwoFer()

        assertEquals("One for Bob, one for me.", twoFer.twofer("Bob"))
    }

    @Test
    fun emptyStringGiven() {
        val twoFer = TwoFer()

        assertEquals("One for , one for me.", twoFer.twofer(""))
    }
}