package com.rgos_developer.projetomvvmcleanhilt.data.repository

import android.util.Log
import com.rgos_developer.projetomvvmcleanhilt.data.dto.toUser
import com.rgos_developer.projetomvvmcleanhilt.data.remote.DummyAPI
import com.rgos_developer.projetomvvmcleanhilt.domain.models.User
import com.rgos_developer.projetomvvmcleanhilt.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dummyAPI: DummyAPI
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        try {
            val response = dummyAPI.getUsers()

            if(response.isSuccessful && response.body() != null){
                val resultApiDTO = response.body()

                val listUsers = resultApiDTO?.users

                if(listUsers != null){
                    return listUsers.map {users ->
                        users.toUser()
                    }
                }
            }else{
                Log.i("lista_usuarios", "${response.message()}")
            }
        }catch (errorGetUsers: Exception){
            errorGetUsers.printStackTrace()
        }

        return emptyList()
    }
}