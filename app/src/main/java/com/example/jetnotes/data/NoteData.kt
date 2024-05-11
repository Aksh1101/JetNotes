package com.example.jetnotes.data

import com.example.jetnotes.model.Note

class NotesDataSource{
     fun loadNotes(): List<Note>{
         return listOf(
             Note(title = "A good day", description = "We went for a Coffee"),
             Note(title = "Android Compose", description = "Working on Compose"),
             Note(title = "Early Morning", description = "We Hit Gym")


         )
     }
 }