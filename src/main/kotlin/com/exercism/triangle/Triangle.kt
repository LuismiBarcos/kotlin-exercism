package com.exercism.triangle

class Triangle<out T : Number>(val a: T, private val b: T, private val c: T) {

    init {
        require(a.toDouble() > 0 && b.toDouble() > 0 && c.toDouble() > 0) { "All sides must be greater than 0" }
        require(a.toDouble() + b.toDouble() >= c.toDouble() &&
                b.toDouble() + c.toDouble() >= a.toDouble() &&
                c.toDouble() + a.toDouble() >= b.toDouble()) { "Triangle Inequality violated" }
    }

    val isEquilateral: Boolean
        get() = a == b && b == c

    val isIsosceles: Boolean
        get() = a == b || b == c || c == a

    val isScalene: Boolean
        get() = a != b && b != c && c != a
}
