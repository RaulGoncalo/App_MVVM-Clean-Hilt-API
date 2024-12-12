package com.rgos_developer.projetomvvmcleanhilt.domain.usecases

import com.rgos_developer.projetomvvmcleanhilt.domain.models.User
import com.rgos_developer.projetomvvmcleanhilt.domain.models.toUserPresentation
import com.rgos_developer.projetomvvmcleanhilt.domain.repository.UserRepository
import com.rgos_developer.projetomvvmcleanhilt.presentation.models.UserPresentation
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend fun getUsers() : List<UserPresentation>{
        return try {
            //Regras de negocios
            //pode ter muito mais código, validações, chamdas de outras useCases
            repository.getUsers().map {
                it.toUserPresentation()
            }
        }catch (errorGetUsers: Exception){
            errorGetUsers.printStackTrace()
            emptyList()
        }
    }
}