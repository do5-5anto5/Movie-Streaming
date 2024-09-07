package com.do55anto5.moviestreaming.di

import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

val firebaseModule = module {
    single<FirebaseAuth> { FirebaseAuth.getInstance() }
}