package com.example.nanitassignmentclient.babybirthday.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nanitassignmentclient.R
import com.example.nanitassignmentclient.babybirthday.domain.model.AgeUnit
import com.example.nanitassignmentclient.babybirthday.ui.model.BabyInfoUiModel
import com.example.nanitassignmentclient.common.theme.FoxTheme

@Composable
fun BabyBirthdayInfo(babyInfo: BabyInfoUiModel, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Text(
            text = stringResource(R.string.today_is, babyInfo.name),
            style = MaterialTheme.typography.headlineSmall,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(13.dp))

        BabyBirthdayAgeCounter(
            age = babyInfo.age,
            modifier = Modifier.wrapContentSize()
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = getAgeText(
                age = babyInfo.age,
                unit = babyInfo.ageUnit
            ),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
private fun getAgeText(age: Int, unit: AgeUnit): String {
    val res = LocalContext.current.resources
    return when (unit) {
        AgeUnit.MONTHS -> res.getQuantityString(R.plurals.age_months, age, age)
        AgeUnit.YEARS -> res.getQuantityString(R.plurals.age_years, age, age)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBabyBirthdayInfo() {
    BabyBirthdayInfo(
        BabyInfoUiModel("Liam", age = 2, AgeUnit.MONTHS, FoxTheme)
    )
}