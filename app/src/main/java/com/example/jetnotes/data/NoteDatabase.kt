package com.example.jetnotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.jetnotes.model.Note
import com.example.jetnotes.util.DateConvertor
import com.example.jetnotes.util.UUIDConvertor

@Database(entities = [Note ::class] , version = 1 , exportSchema = false)
@TypeConverters(DateConvertor::class,UUIDConvertor::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}