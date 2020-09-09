package com.example.kotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin.R
import com.example.kotlin.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        rv_notes.layoutManager = GridLayoutManager(this, 2)
        adapter = NotesRVAdapter {
            NoteActivity.start(this, it)
        }

        rv_notes.adapter = adapter

        viewModel.viewState().observe(this, Observer { state ->
            state?.let { state ->
                adapter.notes = state.notes
            }
        })

        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }
}