package com.example.notas.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notas.ui.AdapterNote
import com.example.notas.R
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

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapterNotes
        recyclerView.layoutManager = LinearLayoutManager(this)

        // initializing Viewmodel
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        notesViewModel.getNotes().observe(this, Observer { data ->
            data?.let {
                adapterNotes.add(it)
            }
        })
    }

    // adding option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    // click detection treatment
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add){
            //TODO: calling AddNote screen
        }
        return super.onOptionsItemSelected(item)
    }
}