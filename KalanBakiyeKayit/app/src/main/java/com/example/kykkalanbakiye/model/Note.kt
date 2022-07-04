package com.example.kykkalanbakiye.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val ID:Int=0,
    val adSoyad:String="",
    val borc:Double=0.0,
    val odaNo:Int=0
):Parcelable
