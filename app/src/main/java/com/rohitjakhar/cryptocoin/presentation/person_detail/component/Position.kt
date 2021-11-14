package com.rohitjakhar.cryptocoin.presentation.person_detail.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rohitjakhar.cryptocoin.data.remote.dto.PersonDetailDto

@Composable
fun Position(
    position: PersonDetailDto.Position,
    onCoinClick: (String) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(20.dp)
            .clickable {
                onCoinClick.invoke(position.coinId)
            }
    ) {
        Text(
            text = "${position.position} at ${position.coinName} (${position.coinSymbol})"
        )
    }
}
