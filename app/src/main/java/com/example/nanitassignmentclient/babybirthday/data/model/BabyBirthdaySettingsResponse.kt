package com.example.nanitassignmentclient.babybirthday.data.model

import com.example.nanitassignmentclient.babybirthday.data.serializer.LocalDateAsEpochMillisSerializer
import com.example.nanitassignmentclient.babybirthday.data.serializer.ThemeSerializer
import com.example.nanitassignmentclient.babybirthday.domain.model.Theme
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class BabyBirthdaySettingsResponse(
    val name: String,
    @Serializable(with = LocalDateAsEpochMillisSerializer::class)
    val dob: LocalDate,
    @Serializable(with = ThemeSerializer::class)
    val theme: Theme,
)