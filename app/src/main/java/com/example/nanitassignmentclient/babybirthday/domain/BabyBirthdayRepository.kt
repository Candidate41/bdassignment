package com.example.nanitassignmentclient.babybirthday.domain

import com.example.nanitassignmentclient.babybirthday.domain.model.BabyBirthdaySettings
import kotlinx.coroutines.flow.Flow

interface BabyBirthdayRepository {

    suspend fun listenForBirthdaySettings(host: String): Flow<BabyBirthdaySettings>
}