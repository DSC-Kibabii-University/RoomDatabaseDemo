package com.kanyideveloper.roomdatabasedemo.database

import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    fun insertNote(notes: Note)

    @Delete
    fun deleteNote(notes: Note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes() : List<Note>

    @Update
    fun updateNote(notes: Note)
}