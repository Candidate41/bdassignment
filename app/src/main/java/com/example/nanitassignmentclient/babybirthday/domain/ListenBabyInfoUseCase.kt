package com.example.nanitassignmentclient.babybirthday.domain

import com.example.nanitassignmentclient.babybirthday.domain.exception.UnsupportedAgeException
import com.example.nanitassignmentclient.babybirthday.domain.model.AgeUnit
import com.example.nanitassignmentclient.babybirthday.domain.model.BabyInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.Period

class ListenBabyInfoUseCase(
    private val repository: BabyBirthdayRepository,
) {

    suspend operator fun invoke(host: String): Flow<Result<BabyInfo>> {
        return repository.listenForBirthdaySettings(host).map { settings ->
            val period = Period.between(settings.dob, LocalDate.now())

             when {
                period.years > 9 -> Result.failure(UnsupportedAgeException())
                period.years > 0 -> Result.success(BabyInfo(settings.name, period.years, AgeUnit.YEARS, settings.theme))

                else -> Result.success(BabyInfo(settings.name, period.months, AgeUnit.MONTHS, settings.theme))
            }
        }
    }
}