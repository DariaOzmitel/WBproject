package com.example.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.MetroStation
import com.example.ui.R
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

@Composable
internal fun MetroStationRow(modifier: Modifier = Modifier, metroStation: MetroStation) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.padding(end = EventTheme.dimensions.dimension4),
            painter = painterResource(R.drawable.metro),
            contentDescription = "",
            tint = metroStation.color
        )
        TextSecondary(text = stringResource(id = metroStation.nameStringId))
    }
}

@Preview
@Composable
private fun MetroStationRowPreview() {
    MetroStationRow(metroStation = MetroStation.PRIMORSKAYA)
}