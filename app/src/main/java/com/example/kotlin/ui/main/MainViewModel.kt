package com.example.kotlin.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import com.example.kotlin.data.NotesRepository
import com.example.kotlin.data.entity.Note
import com.example.kotlin.data.model.NoteResult
import com.example.kotlin.ui.base.BaseViewModel

class MainViewModel(notesRepository: NotesRepository) : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = Observer<NoteResult> { result ->
        result ?: return@Observer
        when (result) {
            is NoteResult.Success<*> -> {
                viewStateLiveData.value = MainViewState(notes = result.data as? List<Note>)
            }
            is NoteResult.Error -> {
                viewStateLiveData.value = MainViewState(error = result.error)
            }
        }
    }

    private val repositoryNotes = notesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
    }

    @VisibleForTesting
    public override fun onCleared() {
        repositoryNotes.removeObserver(notesObserver)
        super.onCleared()
    }
}
