package com.example.nanitassignmentclient.babybirthday.ui.mapper

import com.example.nanitassignmentclient.babybirthday.domain.model.BabyInfo
import com.example.nanitassignmentclient.babybirthday.domain.model.Theme
import com.example.nanitassignmentclient.babybirthday.ui.model.BabyInfoUiModel
import com.example.nanitassignmentclient.common.theme.ElephantTheme
import com.example.nanitassignmentclient.common.theme.FoxTheme
import com.example.nanitassignmentclient.common.theme.PelicanTheme

fun BabyInfo.toUiModel(): BabyInfoUiModel {
    return BabyInfoUiModel(
        name = name,
        age = age,
        ageUnit = ageUnit,
        theme = theme.toUiModel(),
    )
}

fun Theme.toUiModel() = when (this) {
    Theme.FOX -> FoxTheme
    Theme.ELEPHANT -> ElephantTheme
    Theme.PELICAN -> PelicanTheme
}