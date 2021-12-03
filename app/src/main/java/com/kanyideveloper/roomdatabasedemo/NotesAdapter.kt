package com.kanyideveloper.roomdatabasedemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.roomdatabasedemo.database.Note
import com.kanyideveloper.roomdatabasedemo.databinding.NoteRowBinding


class NotesAdapter : ListAdapter<Note, NotesAdapter.MyViewHolder>(MyDiffUtil) {

    object MyDiffUtil : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

    }

    inner class MyViewHolder(private val binding: NoteRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note?) {
            binding.textView1.text = note?.noteTitle
            binding.textView2.text = note?.noteDescription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            NoteRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }
}