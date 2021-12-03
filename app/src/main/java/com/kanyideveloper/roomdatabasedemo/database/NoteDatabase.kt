package com.kanyideveloper.roomdatabasedemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class],exportSchema = false, version = 1)
abstract class NoteDatabase : RoomDatabase() {

    //Access methods in the DAO class
    abstract val notesDao: NoteDao

    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context) : NoteDatabase{

            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        NoteDatabase::class.java,
                        "notes_database").build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}