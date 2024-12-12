package com.rgos_developer.projetomvvmcleanhilt.data.remote

import com.rgos_developer.projetomvvmcleanhilt.data.dto.ResultApiDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {

    @GET("users")
    suspend fun getUsers() : Response<ResultApiDTO>
}