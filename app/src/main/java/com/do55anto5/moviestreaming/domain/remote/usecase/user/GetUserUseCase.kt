package com.do55anto5.moviestreaming.domain.remote.usecase.user

import com.do55anto5.moviestreaming.domain.remote.model.User
import com.do55anto5.moviestreaming.domain.remote.repository.user.UserRepository

class GetUserUseCase(
    private val repository: UserRepository
) {

    suspend operator fun invoke() : User {
        return repository.getUser()
    }

}