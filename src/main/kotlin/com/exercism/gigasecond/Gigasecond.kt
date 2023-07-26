package com.exercism.gigasecond

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(date: LocalDateTime) {

    constructor(date: LocalDate) : this(date.atStartOfDay())

    var date: LocalDateTime = date.plus(Duration.ofSeconds(1_000_000_000))
}