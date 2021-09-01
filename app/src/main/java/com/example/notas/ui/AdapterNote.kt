package com.example.notas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notas.R
import com.example.notas.data.Note

class NotesViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bindView(item: Note){
        with(view){
            val textView: TextView = findViewById(R.id.tv_note)
            textView.text = item.text
        }
    }
}

class AdapterNote(private val data: MutableList<Note> = mutableListOf()):
    RecyclerView.Adapter<NotesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nota,parent,false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) =
        holder.bindView(data[position])

    override fun getItemCount(): Int = data.size

    fun add(item: Note){
        data.add(item)
        notifyDataSetChanged()
    }

    fun add(itens: List<Note>){
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove (item: Note){
        data.remove(item)
        notifyDataSetChanged()
    }
}