package com.do55anto5.moviestreaming.di

import com.do55anto5.moviestreaming.core.preferences.AppPreferences
import org.koin.dsl.module

val localModule = module {
    single<AppPreferences> {
        AppPreferences(context = get())
    }
}