package com.example.nanitassignmentclient.babybirthday.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nanitassignmentclient.R

private val babyBirthMonthImages = listOf(
    R.drawable.img_babybirth_0,
    R.drawable.img_babybirth_1,
    R.drawable.img_babybirth_2,
    R.drawable.img_babybirth_3,
    R.drawable.img_babybirth_4,
    R.drawable.img_babybirth_5,
    R.drawable.img_babybirth_6,
    R.drawable.img_babybirth_7,
    R.drawable.img_babybirth_8,
    R.drawable.img_babybirth_9,
    R.drawable.img_babybirth_10,
    R.drawable.img_babybirth_11
)

@Composable
fun BabyBirthdayAgeCounter(age: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_left_swirls),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(22.dp))

        Image(
            painter = painterResource(id = babyBirthMonthImages[age]),
            contentDescription = "Baby's age",
        )

        Spacer(modifier = Modifier.width(22.dp))

        Image(
            painter = painterResource(id = R.drawable.img_right_swirls),
            contentDescription = null,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBabyBirthdayAgeCounter() {
    BabyBirthdayAgeCounter(
        age = 2,
        modifier = Modifier.wrapContentSize()
    )
}