package com.example.nanitassignmentclient.babybirthday.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nanitassignmentclient.R

@Composable
fun BabyBirthdayBackground(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        content()

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.logo_nanit),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(30.dp)
                .wrapContentWidth()
                .padding(WindowInsets.safeDrawing.only(WindowInsetsSides.Bottom).asPaddingValues())
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBabyBirthdayBackground() {
    BabyBirthdayBackground(R.drawable.bg_babybirthday_fox) {
    }
}