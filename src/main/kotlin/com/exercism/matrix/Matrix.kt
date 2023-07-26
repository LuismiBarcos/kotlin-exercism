package com.exercism.matrix

class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> {
        return matrixAsString.split("\n")
            .map { it.split(" ") }
            .map { it[colNr - 1].toInt() }
    }

    fun row(rowNr: Int): List<Int> {
        return matrixAsString.split("\n")
            .map { it.split(" ") }[rowNr - 1]
            .map { it.toInt() }
    }
}
