package com.example.redmine.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    redmineUiState: RedmineUiState,
    modifier: Modifier = Modifier
) {
    when (redmineUiState) {
        is RedmineUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is RedmineUiState.Success -> SuccessScreen(modifier = modifier.fillMaxSize())
        is RedmineUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "loading...")
}

@Composable
fun SuccessScreen(modifier: Modifier = Modifier) {
    Text(text = "Success!")
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "Error!")
}

