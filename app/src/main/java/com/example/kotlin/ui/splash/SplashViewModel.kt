package com.example.kotlin.ui.splash

import com.example.kotlin.data.NotesRepository
import com.example.kotlin.data.errors.NoAuthException
import com.example.kotlin.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(val notesRepository: NotesRepository) : BaseViewModel<Boolean?>() {
    fun requestUser() = launch {
        notesRepository.getCurrentUser()?.let {
            setData(true)
        } ?: let {
            setError(NoAuthException())
        }
    }
}
