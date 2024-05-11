package com.example.jetnotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "Notes_Table")
data class Note(
    @PrimaryKey
    val id : UUID = UUID.randomUUID(),

    @ColumnInfo(name = "Note_Title")
    val title: String,

    @ColumnInfo(name ="Note_Description" )
    val description :String,

    @ColumnInfo(name = "Note_Entry_Date")
    val entryDate: Date = Date.from(Instant.now())
)
