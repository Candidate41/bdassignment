package com.example.nanitassignmentclient.babybirthday.data

import com.example.nanitassignmentclient.babybirthday.data.mapper.toDomain
import com.example.nanitassignmentclient.babybirthday.domain.BabyBirthdayRepository
import com.example.nanitassignmentclient.babybirthday.domain.model.BabyBirthdaySettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BabyBirthdayKtorRepository(
    private val babyBirthdayClient: BabyBirthdayClient
) : BabyBirthdayRepository {

    override suspend fun listenForBirthdaySettings(host: String): Flow<BabyBirthdaySettings> {
        return babyBirthdayClient.listenForBirthdaySettings(host).map { it.toDomain() }
    }
}