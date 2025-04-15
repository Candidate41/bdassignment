package com.example.nanitassignmentclient.babybirthday.domain.model

import java.time.LocalDate

data class BabyBirthdaySettings(
    val name: String,
    val dob: LocalDate,
    val theme: Theme,
)