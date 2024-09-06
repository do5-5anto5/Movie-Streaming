package com.do55anto5.moviestreaming.domain.remote.usecase.authentication

import com.do55anto5.moviestreaming.domain.remote.repository.authentication.SignupRepository

class RegisterUseCase(
    private val repository: SignupRepository
) {

    suspend operator fun invoke(email: String, password: String) {
        repository.register(email, password)
    }

}