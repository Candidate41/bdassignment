package com.example.nanitassignmentclient.babybirthday.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nanitassignmentclient.babybirthday.domain.ListenBabyInfoUseCase
import com.example.nanitassignmentclient.babybirthday.domain.IsValidHostAddressUseCase
import com.example.nanitassignmentclient.babybirthday.domain.exception.InvalidHostException
import com.example.nanitassignmentclient.babybirthday.ui.model.BabyBirthdayState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BabyBirthdayViewModel @Inject constructor(
    private val listenBabyInfoUseCase: ListenBabyInfoUseCase,
    private val isValidHostAddressUseCase: IsValidHostAddressUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<BabyBirthdayState>(BabyBirthdayState.SettingsRequired)
    val state: StateFlow<BabyBirthdayState> = _state

    private var host: String? = null

    init {
        fetchBabyInfo()
    }

    fun setHostAddress(host: String) {
        if (!isValidHostAddressUseCase(host)) {
            _state.value = BabyBirthdayState.Error(InvalidHostException())
            return
        }

        this.host = host
        fetchBabyInfo()
    }

    fun resetHostAddress() {
        host = null
        _state.value = BabyBirthdayState.SettingsRequired
    }

    fun fetchBabyInfo() = viewModelScope.launch {
        if (host == null) return@launch
        _state.value = BabyBirthdayState.Loading

        listenBabyInfoUseCase.invoke(requireNotNull(host)).collect { settings ->
            settings.onSuccess { _state.value = BabyBirthdayState.Success(it) }
                .onFailure { _state.value = BabyBirthdayState.Error(it.cause) }
        }
    }
}