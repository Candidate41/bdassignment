package com.example.nanitassignmentclient.babybirthday.ui.model

import com.example.nanitassignmentclient.babybirthday.domain.model.AgeUnit
import com.example.nanitassignmentclient.common.theme.BabyBirthdayTheme

data class BabyInfoUiModel(
    val name: String,
    val age: Int,
    val ageUnit: AgeUnit,
    val theme: BabyBirthdayTheme,
)
