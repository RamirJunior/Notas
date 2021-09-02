package com.example.notas.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notas.R
import com.example.notas.ui.AdapterNote
import com.example.notas.viewmodels.NotesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var notesViewModel: NotesViewModel
    private val adapterNotes: AdapterNote by lazy{
        AdapterNote()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        startRecyclerView()

        setViewModel()
    }

    private fun setViewModel() {
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        notesViewModel.getNotes().observe(this, { data ->
            data?.let {
                if (it.isEmpty()) {
                    Toast.makeText(this, "Lista vazia", Toast.LENGTH_LONG).show()
                } else {
                    adapterNotes.add(it)
                }
            }
        })
    }

    private fun startRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapterNotes
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    // adding option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // click detection treatment
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add) {
            dialogAddNote()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogAddNote() {
        val layout = LayoutInflater.from(this)
            .inflate(R.layout.dialog_ui, null, false)

//        val dialog = AlertDialog.Builder()this.apply {  }
    }
}
