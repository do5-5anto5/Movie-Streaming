package com.do55anto5.moviestreaming.core.preferences

import android.content.Context
import com.do55anto5.moviestreaming.core.constants.SharedPreferenceKeys.FILE_NAME
import com.do55anto5.moviestreaming.core.constants.SharedPreferenceKeys.WELCOME_VISITED

class AppPreferences(context: Context) {
    private val sharedPref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    fun saveWelcomeVisited(visited: Boolean) {
        sharedPref.edit().putBoolean(WELCOME_VISITED, visited).apply()
    }
    fun getWelcomeVisited(): Boolean {
        return sharedPref.getBoolean(WELCOME_VISITED, false)
    }
}