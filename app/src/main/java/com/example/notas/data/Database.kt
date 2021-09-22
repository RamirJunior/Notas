package com.example.notas.data

import androidx.lifecycle.MutableLiveData

class Database {

    private val mData: MutableLiveData<MutableList<Note>> = MutableLiveData()

    fun insertNote(note: Note){
        var tmp = mData.value
        if(tmp == null) {
            tmp = mutableListOf()
            tmp.add(note)
        } else {
            tmp.add(note)
        }
        mData.postValue(tmp!!)
    }

    fun getNotes() = mData
}