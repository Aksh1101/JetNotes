package com.example.jetnotes.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnotes.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {

    @Query("Select * from notes_table")
    fun getNotes(): Flow<List<Note>>

    @Query("Select * from notes_table where id=:id")
    suspend fun getNotesByID(id : String) :Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("Delete from notes_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)


}
