package com.do55anto5.moviestreaming.di

import com.do55anto5.moviestreaming.data.remote.repository.authentication.AuthenticationRepositoryImpl
import com.do55anto5.moviestreaming.data.remote.repository.user.UserRepositoryImpl
import com.do55anto5.moviestreaming.domain.remote.repository.authentication.AuthenticationRepository
import com.do55anto5.moviestreaming.domain.remote.repository.user.UserRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<AuthenticationRepository> { AuthenticationRepositoryImpl() }

    factory<UserRepository> { UserRepositoryImpl() }

}