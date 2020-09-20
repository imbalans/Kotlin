package com.example.kotlin.data

import com.example.kotlin.data.entity.Note
import com.example.kotlin.data.provider.DataProvider

class NotesRepository(val remoteProvider: DataProvider) {
    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
    fun deleteNote(id: String) = remoteProvider.deleteNote(id)
    fun getCurrentUser() = remoteProvider.getCurrentUser()
}