package com.example.nanitassignmentclient.babybirthday.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nanitassignmentclient.babybirthday.domain.model.AgeUnit
import com.example.nanitassignmentclient.babybirthday.ui.model.BabyInfoUiModel
import com.example.nanitassignmentclient.common.theme.FoxTheme

@Composable
fun BabyBirthdayContent(babyInfo: BabyInfoUiModel) {
    BabyBirthdayBackground(
        image = babyInfo.theme.backgroundImage,
        modifier = Modifier.background(colorResource(id = babyInfo.theme.backgroundColor))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(WindowInsets.safeDrawing.asPaddingValues()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Spacer(
                modifier = Modifier
                    .heightIn(min = 20.dp)
                    .weight(1f)
            )

            BabyBirthdayInfo(babyInfo)

            Spacer(
                modifier = Modifier
                    .heightIn(min = 15.dp)
                    .weight(1f)
            )

            BabyBirthdayImage(
                theme = babyInfo.theme,
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .aspectRatio(1f)
                    .fillMaxWidth()
            )

            // 15dp space + 30dp image
            Spacer(modifier = Modifier.height(45.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBabyBirthdayContent() {
    BabyBirthdayContent(BabyInfoUiModel("Igor", 4, AgeUnit.MONTHS, FoxTheme))
}