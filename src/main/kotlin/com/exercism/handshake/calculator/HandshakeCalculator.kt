package com.exercism.handshake.calculator

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        return toSignalList(toBinary(number))
    }

    private fun toBinary(number: Int): List<Int> {
        return Integer.toBinaryString(number)
            .padStart(5,'0')
            .map { it.toString().toInt() }
    }

    private fun toSignalList(binary: List<Int>): List<Signal> {
        return Signal.values()
            .map { getSignal(binary, it) }
            .filter { Signal.NONE != it }
            .apply {
                if(this.contains(Signal.REVERSE)) {
                    return this.filter { it != Signal.REVERSE }
                        .reversed()
                }
            }.distinct()
    }

    private fun getSignal(binary: List<Int>, signal: Signal): Signal {
        return when(signal) {
            Signal.WINK -> if(binary[4] == 1) Signal.WINK else Signal.NONE
            Signal.DOUBLE_BLINK -> if(binary[3] == 1) Signal.DOUBLE_BLINK else Signal.NONE
            Signal.CLOSE_YOUR_EYES -> if(binary[2] == 1) Signal.CLOSE_YOUR_EYES else Signal.NONE
            Signal.JUMP -> if(binary[1] == 1) Signal.JUMP else Signal.NONE
            Signal.REVERSE -> if(binary[0] == 1) Signal.REVERSE else Signal.NONE
            else -> Signal.NONE
        }
    }
}

enum class Signal {
    WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP, REVERSE, NONE
}