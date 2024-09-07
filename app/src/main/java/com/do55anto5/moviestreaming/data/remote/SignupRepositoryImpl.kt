package com.do55anto5.moviestreaming.data.remote

import com.do55anto5.moviestreaming.domain.remote.repository.authentication.SignupRepository
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.suspendCoroutine

class SignupRepositoryImpl(
    private val auth: FirebaseAuth
) : SignupRepository {

    override suspend fun register(email: String, password: String) {
        return suspendCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // handle register state
                    } else {
                        // handle register state
                    }
                }
        }
    }

}