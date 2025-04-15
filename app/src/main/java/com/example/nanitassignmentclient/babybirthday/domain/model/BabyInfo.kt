package com.example.nanitassignmentclient.babybirthday.domain.model

data class BabyInfo(
    val name: String,
    val age: Int,
    val ageUnit: AgeUnit,
    val theme: Theme,
)

enum class AgeUnit {
    MONTHS,
    YEARS
}