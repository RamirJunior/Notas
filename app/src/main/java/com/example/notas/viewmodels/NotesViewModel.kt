package com.example.notas.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notas.data.Note
import com.example.notas.data.NotesManager

class NotesViewModel: ViewModel() {

    private val notesManager = NotesManager()
    private var mNotes: MutableLiveData<List<Note>>? = null

    fun getNotes(): LiveData<List<Note>> {
        if (mNotes == null) {
            mNotes = MutableLiveData()
            loadNotes()
        }
        return mNotes!!
    }

    fun loadNotes() {
        val tmp = notesManager.getNotes()
        mNotes!!.postValue(tmp)
    }
}
