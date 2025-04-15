package com.example.nanitassignmentclient.babybirthday.ui.model

import com.example.nanitassignmentclient.babybirthday.domain.model.BabyInfo

sealed class BabyBirthdayState {
    object SettingsRequired : BabyBirthdayState()
    object Loading : BabyBirthdayState()
    data class Error(val ex: Throwable?) : BabyBirthdayState()
    data class Success(val babyInfo: BabyInfo) : BabyBirthdayState()
}