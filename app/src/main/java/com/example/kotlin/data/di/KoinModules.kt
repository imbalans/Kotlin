package com.example.kotlin.data.di

import com.example.kotlin.data.NotesRepository
import com.example.kotlin.data.provider.DataProvider
import com.example.kotlin.data.provider.FirestoreDataProvider
import com.example.kotlin.ui.main.MainViewModel
import com.example.kotlin.ui.note.NoteViewModel
import com.example.kotlin.ui.splash.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single { FirestoreDataProvider(get(), get()) } bind DataProvider::class
    single { NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}