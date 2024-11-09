package com.do55anto5.moviestreaming.presenter.screens.main.account.state

import com.do55anto5.moviestreaming.core.enums.feedback.FeedbackType
import com.do55anto5.moviestreaming.domain.remote.model.User


data class AccountState(
    val isLoading: Boolean = true,
    val user: User? = null,
    val hasFeedback: Boolean = false,
    val feedbackUI: Pair<FeedbackType, String>? = null
)