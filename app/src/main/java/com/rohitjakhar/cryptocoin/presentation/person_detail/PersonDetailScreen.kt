package com.rohitjakhar.cryptocoin.presentation.person_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rohitjakhar.cryptocoin.presentation.person_detail.component.Position

@Composable
fun PersonDetailScreen(
    navController: NavController,
    viewModel: PersonDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(20.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            state.personDetails?.let { personDetail ->
                item {
                    Text(
                        text = "Name: ${personDetail.name}"
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    personDetail.description?.let {
                        Text(
                            text = it
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Github: ${personDetail.githubLink}"
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "LinkedIn: ${personDetail.linkedinLink}"
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Twitter: ${personDetail.twitterLink}"
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Medium: ${personDetail.mediumLink}"
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                }
                items(personDetail.position) { position ->
                    Position(
                        position = position
                    )
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
