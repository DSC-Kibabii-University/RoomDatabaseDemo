package com.kanyideveloper.roomdatabasedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kanyideveloper.roomdatabasedemo.database.NoteDao
import com.kanyideveloper.roomdatabasedemo.database.NoteDatabase
import com.kanyideveloper.roomdatabasedemo.databinding.ActivityAddNoteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.kanyideveloper.roomdatabasedemo.database.Note

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var noteDao: NoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteDatabase =  NoteDatabase.getInstance(applicationContext)
        noteDao = noteDatabase.notesDao

        binding.buttonAdd.setOnClickListener {
            if (binding.noteTitleTextView.text.toString().isEmpty() ||
                binding.noteDescriptionTextView.text.toString().isEmpty()){
                return@setOnClickListener
            }else{
                CoroutineScope(Dispatchers.IO).launch {
                    val note = Note(0,
                        binding.noteTitleTextView.text.toString(),
                        binding.noteDescriptionTextView.text.toString()
                    )
                    noteDao.insertNote(note)
                    startActivity(Intent(this@AddNoteActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}