package com.kanyideveloper.roomdatabasedemo.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteTitle: String? = null,
    val noteDescription: String? = null
)