package com.example.notas.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notas.data.Note
import com.example.notas.data.NotesManager

class NotesViewModel: ViewModel() {
    private val notesManager = NotesManager()
    private val mNotes = MutableLiveData<List<Note>>()

    fun getNotes(): MutableLiveData<List<Note>> = mNotes

    fun loadNotes(){
        var tmp = notesManager.getNotes()
        mNotes.postValue(tmp)
    }
}