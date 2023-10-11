package com.example.redmine.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.redmine.ui.screens.HomeScreen
import com.example.redmine.ui.screens.RedmineViewModel

@Composable
fun RedmineApp() {
    val redmineViewModel: RedmineViewModel =
        viewModel(factory = RedmineViewModel.Factory)
    HomeScreen(redmineUiState = )
}