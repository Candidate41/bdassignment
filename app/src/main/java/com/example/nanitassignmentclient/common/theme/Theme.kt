package com.example.nanitassignmentclient.common.theme

import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.nanitassignmentclient.R

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

data class BabyBirthdayTheme(
    @DrawableRes val backgroundImage: Int,
    @ColorRes val backgroundColor: Int,
    @DrawableRes val placeholder: Int,
    @DrawableRes val shareIcon: Int
)

val PelicanTheme = BabyBirthdayTheme(
    backgroundImage = R.drawable.bg_babybirthday_pelican,
    backgroundColor = R.color.pelican,
    placeholder = R.drawable.placeholder_babybirthday_pelican,
    shareIcon = R.drawable.ic_share_pelican
)

val FoxTheme = BabyBirthdayTheme(
    backgroundImage = R.drawable.bg_babybirthday_fox,
    backgroundColor = R.color.fox,
    placeholder = R.drawable.placeholder_babybirthday_fox,
    shareIcon = R.drawable.ic_share_fox
)

val ElephantTheme = BabyBirthdayTheme(
    backgroundImage = R.drawable.bg_babybirthday_elephant,
    backgroundColor = R.color.elephant,
    placeholder = R.drawable.placeholder_babybirthday_elephant,
    shareIcon = R.drawable.ic_share_elephant
)

@Composable
fun NanitAssignmentClientTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}