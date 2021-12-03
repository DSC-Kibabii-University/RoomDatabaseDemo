package com.kanyideveloper.roomdatabasedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kanyideveloper.roomdatabasedemo.database.NoteDao
import com.kanyideveloper.roomdatabasedemo.database.NoteDatabase
import com.kanyideveloper.roomdatabasedemo.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var notesDao: NoteDao

    private val adapter by lazy { NotesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteDatabase = NoteDatabase.getInstance(applicationContext)
        notesDao = noteDatabase.notesDao

        GlobalScope.launch {

            adapter.submitList(notesDao.getAllNotes())
            binding.recyclerview.adapter = adapter

        }

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }
}