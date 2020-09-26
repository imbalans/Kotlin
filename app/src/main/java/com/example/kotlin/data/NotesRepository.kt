package com.example.kotlin.data

import com.example.kotlin.data.entity.Note
import com.example.kotlin.data.provider.DataProvider

class NotesRepository(val remoteProvider: DataProvider) {
    fun getNotes() = remoteProvider.subscribeToAllNotes()
    suspend fun saveNote(note: Note) = remoteProvider.saveNote(note)
    suspend fun getNoteById(id: String) = remoteProvider.getNoteById(id)
    suspend fun deleteNote(id: String) = remoteProvider.deleteNote(id)
    suspend fun getCurrentUser() = remoteProvider.getCurrentUser()
}