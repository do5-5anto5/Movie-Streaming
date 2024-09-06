package com.do55anto5.moviestreaming.domain.remote

interface SignupRepository {

    suspend fun register(email: String, password: String)

}