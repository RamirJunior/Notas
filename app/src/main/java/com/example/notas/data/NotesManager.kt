package com.example.notas.data

class NotesManager {
    // Here is where the class receive api data or firebase data
    private val data = listOf<Note>(
        Note(id = 0, text = "Nota 1"),
        Note(id = 0, text = "Nota 2"),
        Note(id = 0, text = "Nota 3"),
        Note(id = 0, text = "Nota 4"),
        Note(id = 0, text = "Nota 5"),
    )
    fun getNotes() = data
}