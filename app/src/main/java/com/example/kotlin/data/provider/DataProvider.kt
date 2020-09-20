package com.example.kotlin.data.provider

import androidx.lifecycle.LiveData
import com.example.kotlin.data.entity.Note
import com.example.kotlin.data.entity.User
import com.example.kotlin.data.model.NoteResult

interface DataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note): LiveData<NoteResult>
    fun deleteNote(noteId: String): LiveData<NoteResult>
    fun getCurrentUser(): LiveData<User?>
}