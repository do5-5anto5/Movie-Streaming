package com.do55anto5.moviestreaming.domain.remote.repository.authentication

interface AuthenticationRepository {

    suspend fun register(email: String, password: String)

}