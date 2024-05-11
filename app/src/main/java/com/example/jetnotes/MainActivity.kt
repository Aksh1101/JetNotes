package com.example.jetnotes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.collection.MutableVector
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnotes.data.NotesDataSource
import com.example.jetnotes.model.Note
import com.example.jetnotes.screen.NoteScreen
import com.example.jetnotes.screen.NoteViewModel
import com.example.jetnotes.ui.theme.JetNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("RememberReturnType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel = viewModel<NoteViewModel>() // also works like the below
                    //val noteViewModel:NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel){
    val notesList =noteViewModel.noteList.collectAsState().value
    NoteScreen(notesList ,
        onRemoveNote = {noteViewModel.deleteNote(it)},
        onAddNote = {noteViewModel.addNote(it)})

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNotesTheme {
    }
}