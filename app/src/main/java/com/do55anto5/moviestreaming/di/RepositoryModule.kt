package com.do55anto5.moviestreaming.di

import com.do55anto5.moviestreaming.data.remote.SignupRepositoryImpl
import com.do55anto5.moviestreaming.domain.remote.repository.authentication.SignupRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<SignupRepository> { SignupRepositoryImpl(auth = get()) }

}