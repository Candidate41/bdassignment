package com.example.nanitassignmentclient.babybirthday

import com.example.nanitassignmentclient.babybirthday.data.BabyBirthdayClient
import com.example.nanitassignmentclient.babybirthday.data.BabyBirthdayKtorRepository
import com.example.nanitassignmentclient.babybirthday.domain.BabyBirthdayRepository
import com.example.nanitassignmentclient.babybirthday.domain.ListenBabyInfoUseCase
import com.example.nanitassignmentclient.babybirthday.domain.IsValidHostAddressUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BabyBirthdayModule {

    @Provides
    fun createBabyBirthdayClient(): BabyBirthdayClient {
        return BabyBirthdayClient()
    }

    @Provides
    fun createBabyBirthdayRepository(client: BabyBirthdayClient): BabyBirthdayRepository {
        return BabyBirthdayKtorRepository(client)
    }

    @Provides
    fun createGetBabyInfoUseCase(repository: BabyBirthdayRepository): ListenBabyInfoUseCase {
        return ListenBabyInfoUseCase(repository)
    }

    @Provides
    fun createIsValidHostAddressUseCase(): IsValidHostAddressUseCase {
        return IsValidHostAddressUseCase()
    }
}
