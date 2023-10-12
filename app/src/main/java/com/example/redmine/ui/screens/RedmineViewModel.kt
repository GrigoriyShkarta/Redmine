package com.example.redmine.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.redmine.RedmineApplication
import com.example.redmine.data.RedmineRepository
import com.example.redmine.model.Redmine
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface RedmineUiState {
    data class Success(val photos: List<Redmine>) : RedmineUiState
    object Error : RedmineUiState
    object Loading : RedmineUiState
}

class RedmineViewModel(private val redmineRepository: RedmineRepository) : ViewModel() {
    var redmineUiState: RedmineUiState by mutableStateOf(RedmineUiState.Loading)
        private set

    init {
        getMyIssues()
    }

    fun getMyIssues() {
        viewModelScope.launch {
            redmineUiState = RedmineUiState.Loading
            redmineUiState = try {
                val issues: List<Redmine> = redmineRepository.getMyIssues()
                RedmineUiState.Success(issues)
            } catch (e: IOException) {
                RedmineUiState.Error
            } catch (e: HttpException) {
                RedmineUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as RedmineApplication)
                val redmineRepository = application.container.redmineRepository
                RedmineViewModel(redmineRepository = redmineRepository)
            }
        }
    }
}