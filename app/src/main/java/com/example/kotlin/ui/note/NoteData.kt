package com.example.kotlin.ui.note

import com.example.kotlin.data.entity.Note
import com.example.kotlin.ui.base.BaseViewState

data class NoteData(val isDeleted: Boolean = false, val note: Note? = null)