package com.example.nanitassignmentclient.babybirthday.data.mapper

import com.example.nanitassignmentclient.babybirthday.data.model.BabyBirthdaySettingsResponse
import com.example.nanitassignmentclient.babybirthday.domain.model.BabyBirthdaySettings

fun BabyBirthdaySettingsResponse.toDomain() = BabyBirthdaySettings(name, dob, theme)