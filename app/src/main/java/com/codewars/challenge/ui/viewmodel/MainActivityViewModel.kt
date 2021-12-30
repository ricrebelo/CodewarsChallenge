package com.codewars.challenge.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewars.challenge.database.entity.Challenges
import com.codewars.challenge.database.repository.ChallengesRepository
import com.codewars.challenge.web.Endpoints
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: ChallengesRepository,
    private val endpoints: Endpoints
) : ViewModel() {

    val isLoading : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val currentUser: MutableStateFlow<String> = MutableStateFlow("")
    val challengesForUserStateFlow: MutableStateFlow<List<Challenges>> = MutableStateFlow(emptyList())

    fun getListCompleteChallenges(userName : String) {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.value = true

            val request = endpoints.getListCompleteChallenges(
                userName = userName
            )

            request.execute().body()?.let { it ->
                it.data.forEach {
                    repository.insert(Challenges(
                        username = userName,
                        completedAt = it.completedAt,
                        completedLanguages = it.completedLanguages,
                        id = it.id,
                        name = it.name,
                        slug = it.slug
                    ))
                }
            }

            challengesForUserStateFlow.value = repository.getChallengesByUserName(userName)
            isLoading.value = false
        }
    }
}