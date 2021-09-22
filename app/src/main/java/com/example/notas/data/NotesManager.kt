package com.example.notas.data

import androidx.lifecycle.MutableLiveData

class NotesManager {

    private val data: MutableLiveData<MutableList<Note>> = MutableLiveData()

    fun getNotes() = data

    fun addNote(mNote: Note) {
        var tmp = data.value
        if(tmp == null) {
            tmp = mutableListOf()
            tmp.add(mNote)
        } else {
            tmp.add(mNote)
        }
        data.postValue(tmp!!)
    }

}