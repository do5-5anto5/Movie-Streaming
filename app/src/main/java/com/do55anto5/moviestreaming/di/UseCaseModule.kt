package com.do55anto5.moviestreaming.di

import com.do55anto5.moviestreaming.domain.remote.usecase.authentication.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { RegisterUseCase(repository = get()) }

}