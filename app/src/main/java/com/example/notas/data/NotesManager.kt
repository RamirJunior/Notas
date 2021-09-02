package com.example.notas.data

class NotesManager {

    private val data = listOf(
        Note(id = 0, text = "Nota 1"),
        Note(id = 0, text = "Nota 2"),
        Note(id = 0, text = "Nota 3"),
        Note(id = 0, text = "Nota 4"),
        Note(id = 0, text = "Nota 5")
    )

    fun getNotes() = data
}