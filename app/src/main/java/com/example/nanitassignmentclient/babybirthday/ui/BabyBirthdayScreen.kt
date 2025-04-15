package com.example.nanitassignmentclient.babybirthday.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nanitassignmentclient.R
import com.example.nanitassignmentclient.babybirthday.ui.component.BabyBirthdayContent
import com.example.nanitassignmentclient.babybirthday.ui.component.BabyBirthdayLoading
import com.example.nanitassignmentclient.babybirthday.ui.mapper.toUiModel
import com.example.nanitassignmentclient.babybirthday.ui.model.BabyBirthdayState

@Composable
fun BabyBirthdayScreen(viewModel: BabyBirthdayViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (state) {
        is BabyBirthdayState.SettingsRequired -> {
            SettingsRequiredDialog(onConfirm = { hostAddress ->
                viewModel.setHostAddress(hostAddress.trim())
            })
        }
        is BabyBirthdayState.Loading -> BabyBirthdayLoading()
        is BabyBirthdayState.Error -> {
            val error = (state as BabyBirthdayState.Error).ex
            ErrorDialog(
                error = error,
                onRetry = { viewModel.fetchBabyInfo() },
                onEnterSettings = { viewModel.resetHostAddress() },
            )
        }
        is BabyBirthdayState.Success -> {
            val babyInfo = (state as BabyBirthdayState.Success).babyInfo
            BabyBirthdayContent(babyInfo.toUiModel())
        }
    }
}

@Composable
fun SettingsRequiredDialog(onConfirm: (String) -> Unit) {
    var inputText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = {},
        title = { Text(stringResource(R.string.host_title)) },
        text = {
            Column {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { Text(stringResource(R.string.host_hint)) }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onConfirm(inputText) }
            ) {
                Text(stringResource(R.string.confirm))
            }
        }
    )
}

@Composable
fun ErrorDialog(
    error: Throwable?,
    onRetry: () -> Unit,
    onEnterSettings: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(stringResource(R.string.error_title)) },
        text = { Text(error?.message ?: stringResource(R.string.error_text)) },
        confirmButton = {
            Button(onClick = onRetry) {
                Text(stringResource(R.string.retry))
            }
        },
        dismissButton = {
            Button(onClick = onEnterSettings) {
                Text(stringResource(R.string.re_enter_host))
            }
        },
    )
}