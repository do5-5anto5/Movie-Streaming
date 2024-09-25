package com.do55anto5.moviestreaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.do55anto5.moviestreaming.core.navigation.hosts.onboarding.OnboardingNavHost
import com.do55anto5.moviestreaming.presenter.theme.MovieStreamingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieStreamingTheme {
                OnboardingNavHost(navHostController = rememberNavController())
            }
        }
    }
}