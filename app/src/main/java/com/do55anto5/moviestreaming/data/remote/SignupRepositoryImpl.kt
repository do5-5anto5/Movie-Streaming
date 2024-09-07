package com.do55anto5.moviestreaming.data.remote

import com.do55anto5.moviestreaming.domain.remote.repository.authentication.SignupRepository
import com.google.firebase.auth.FirebaseAuth

class SignupRepositoryImpl(
    private val auth: FirebaseAuth
) : SignupRepository {

    override suspend fun register(email: String, password: String) {

    }

}