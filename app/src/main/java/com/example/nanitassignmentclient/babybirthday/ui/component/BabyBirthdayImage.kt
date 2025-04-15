package com.example.nanitassignmentclient.babybirthday.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nanitassignmentclient.common.theme.BabyBirthdayTheme
import com.example.nanitassignmentclient.common.theme.FoxTheme
import kotlin.math.cos
import kotlin.math.sin

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun BabyBirthdayImage(theme: BabyBirthdayTheme, modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier) {
        val radiusPx = with(LocalDensity.current) { maxWidth.toPx() / 2 }
        val iconSize = 32.dp

        val angle = Math.toRadians(-45.0)
        val offsetX = (radiusPx * cos(angle)).toFloat()
        val offsetY = (radiusPx * sin(angle)).toFloat()

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(theme.placeholder),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Image(
                painter = painterResource(theme.shareIcon),
                contentDescription = "Camera icon",
                modifier = Modifier
                    .size(iconSize)
                    .graphicsLayer {
                        translationX = offsetX
                        translationY = offsetY
                    }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBabyBirthdayImage() {
    BabyBirthdayImage(theme = FoxTheme)
}
