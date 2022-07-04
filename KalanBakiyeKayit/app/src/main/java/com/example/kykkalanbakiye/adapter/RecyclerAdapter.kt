package com.example.kykkalanbakiye.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kykkalanbakiye.R
import com.example.kykkalanbakiye.model.Note
import com.example.kykkalanbakiye.view.FragmentListDirections
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var noteList= emptyList<Note>()
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ad=view.adSoyad
        val borc=view.borc
        val oda=view.odaNo

        fun bind(note: Note){
            ad.setText(note.adSoyad)
            borc.setText(note.borc.toString())
            oda.setText(note.odaNo.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflate=LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return MyViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note=noteList.get(position)
        holder.bind(note)
        holder.itemView.setOnClickListener {
            val action=FragmentListDirections.actionFragmentListToFragmentUpdate(note)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
    fun setData(noteListt:List<Note>){
       this.noteList=noteListt
        notifyDataSetChanged()

    }
}