package com.example.notas.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notas.data.Database
import com.example.notas.data.NotesManager
import com.example.notas.data.Note

class NotesViewModel: ViewModel() {

    private val database = Database()
    private val notesManager = NotesManager(database)
    private var mNotes: MutableLiveData<MutableList<Note>>? = null

    fun getNotes(): LiveData<MutableList<Note>> {

        if (mNotes == null) {
            mNotes = notesManager.getNotes()
        }
        return mNotes!!
    }

    fun save(mNote: Note){
        notesManager.addNote(mNote)
    }
}
