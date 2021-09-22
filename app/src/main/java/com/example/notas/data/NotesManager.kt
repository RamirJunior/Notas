package com.example.notas.data

class NotesManager(val database: Database) {

    fun getNotes() = database.getNotes()

    fun addNote(mNote: Note) {
        database.insertNote(mNote)
    }

}