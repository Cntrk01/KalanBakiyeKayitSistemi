package com.example.kykkalanbakiye.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kykkalanbakiye.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Query("SELECT*FROM NOTE ORDER BY id ASC")
    fun readAllData():LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(note: Note)

    @Delete
    suspend fun deleteData(note: Note)

    @Update
    suspend fun updateData(note: Note)

    @Query("SELECT*FROM NOTE where adSoyad LIKE :note")
    suspend fun searchData(note: String):List<Note>
}