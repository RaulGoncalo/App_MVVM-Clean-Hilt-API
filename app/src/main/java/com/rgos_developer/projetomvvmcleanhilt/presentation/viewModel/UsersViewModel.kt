package com.rgos_developer.projetomvvmcleanhilt.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rgos_developer.projetomvvmcleanhilt.domain.usecases.GetUsersUseCase
import com.rgos_developer.projetomvvmcleanhilt.presentation.models.UserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _users = MutableLiveData<List<UserPresentation>>()
    val users: LiveData<List<UserPresentation>>
        get() = _users

    init {
        getUsers()
    }

    fun getUsers(){
        viewModelScope.launch {
            _users.postValue(getUsersUseCase.getUsers())
        }
    }

}