package com.example.kykkalanbakiye.database

import androidx.lifecycle.LiveData
import com.example.kykkalanbakiye.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository (private val noteDao:NoteDAO){

    val readAllData:LiveData<List<Note>> =noteDao.readAllData()
    suspend fun addNote(note: Note){
        noteDao.insertData(note)
    }
    suspend fun deleteNote(note: Note){
        noteDao.deleteData(note)
    }
    suspend fun updateNote(note: Note){
        noteDao.insertData(note)
    }
    suspend fun searchNote(note:String):List<Note>{
       return noteDao.searchData(note)
    }

}