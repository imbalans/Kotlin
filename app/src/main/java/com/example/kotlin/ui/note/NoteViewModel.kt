package com.example.kotlin.ui.note

import androidx.lifecycle.ViewModel
import com.example.kotlin.data.NotesRepository
import com.example.kotlin.data.entity.Note

class NoteViewModel : ViewModel() {

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }
}