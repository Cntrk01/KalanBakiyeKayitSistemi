package com.example.kykkalanbakiye.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kykkalanbakiye.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase :RoomDatabase(){
    abstract fun noteDao():NoteDAO
    companion object
    {
        @Volatile
        private var instancee : NoteDatabase?=null
        fun getDatabase(context: Context):NoteDatabase{
            var tempInstance= instancee
            if(tempInstance !=null){
                return tempInstance
            }

            synchronized(this){
                val instance=
                    Room.databaseBuilder(context,NoteDatabase::class.java,"note_database").build()
                tempInstance=instance
                return instance
            }

        }
    }
}