package com.do55anto5.moviestreaming.domain.remote.repository.authentication

interface SignupRepository {

    suspend fun register(email: String, password: String)

}