package com.exercism.hamming

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class HammingTest {

    @Test
    fun `empty strands`() {
        val hamming = Hamming()

        assertEquals(0, hamming.compute("", ""))
    }

    @Test
    fun `single letter identical strands`() {
        val hamming = Hamming()

        assertEquals(0, hamming.compute("A", "A"))
    }

    @Test
    fun `single letter different strands`() {
        val hamming = Hamming()

        assertEquals(1, hamming.compute("G", "T"))
    }

    @Test
    fun `long identical strands`() {
        val hamming = Hamming()

        assertEquals(0, hamming.compute("GGACTGAAATCTG", "GGACTGAAATCTG"))
    }

    @Test
    fun `long different strands`() {
        val hamming = Hamming()

        assertEquals(9, hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

    @Test
    fun `disallow first strand longer`() {
        val hamming = Hamming()

        assertThrows<java.lang.IllegalArgumentException> {
            hamming.compute("AATG", "AAA")
        }
    }

    @Test
    fun `disallow second strand longer`() {
        val hamming = Hamming()

        assertThrows<java.lang.IllegalArgumentException> {
            hamming.compute("ATA", "AGTG")
        }
    }
}