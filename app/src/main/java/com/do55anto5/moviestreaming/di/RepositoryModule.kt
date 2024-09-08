package com.do55anto5.moviestreaming.di

import com.do55anto5.moviestreaming.data.remote.repository.authentication.SignupRepositoryImpl
import com.do55anto5.moviestreaming.data.remote.repository.user.UserRepositoryImpl
import com.do55anto5.moviestreaming.domain.remote.repository.authentication.SignupRepository
import com.do55anto5.moviestreaming.domain.remote.repository.user.UserRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<SignupRepository> { SignupRepositoryImpl() }

    factory<UserRepository> { UserRepositoryImpl() }

}