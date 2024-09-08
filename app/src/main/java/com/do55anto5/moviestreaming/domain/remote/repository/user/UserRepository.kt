package com.do55anto5.moviestreaming.domain.remote.repository.user

import com.do55anto5.moviestreaming.domain.remote.model.User

interface UserRepository {

    suspend fun saveUser(user: User)

}