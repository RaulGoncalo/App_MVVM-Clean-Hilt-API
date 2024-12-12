package com.rgos_developer.projetomvvmcleanhilt.domain.repository

import com.rgos_developer.projetomvvmcleanhilt.domain.models.User

interface UserRepository {
    suspend fun getUsers() : List<User>
}