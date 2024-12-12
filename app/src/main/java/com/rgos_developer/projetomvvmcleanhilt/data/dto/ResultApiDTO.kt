package com.rgos_developer.projetomvvmcleanhilt.data.dto

data class ResultApiDTO(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserDTO>
)