package com.example.kykkalanbakiye.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kykkalanbakiye.model.Note
import com.example.kykkalanbakiye.database.NoteDatabase
import com.example.kykkalanbakiye.database.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {
    val readAllData : LiveData<List<Note>>
    private val noteRepository:NoteRepository

    init {
        val dao=NoteDatabase.getDatabase(application).noteDao()
        readAllData=dao.readAllData()
        noteRepository= NoteRepository(dao)
    }
    fun addUser(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            noteRepository.addNote(note)
        }
    }
    fun deleteUser(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            noteRepository.deleteNote(note)
        }
    }
    fun updateUser(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            noteRepository.updateNote(note)
        }
    }
    fun searchNote(note:String) {
        viewModelScope.launch (Dispatchers.IO){
           noteRepository.searchNote(note)
        }
    }

}