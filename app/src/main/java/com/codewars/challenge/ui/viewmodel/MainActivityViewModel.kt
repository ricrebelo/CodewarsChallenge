package com.codewars.challenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewars.challenge.database.repository.UserRepository
import com.codewars.challenge.web.Endpoints
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: UserRepository,
    private val endpoints: Endpoints
) : ViewModel() {

    fun getUserResult() {
        val user = endpoints.getSpecificUser

        viewModelScope.launch(Dispatchers.IO) {
            user.execute().body()?.let {
                //TODO add to database and show on UI
            }
        }
    }
}