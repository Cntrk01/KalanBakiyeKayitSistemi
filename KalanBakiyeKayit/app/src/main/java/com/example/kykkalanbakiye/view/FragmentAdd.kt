package com.example.kykkalanbakiye.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kykkalanbakiye.R
import com.example.kykkalanbakiye.adapter.RecyclerAdapter
import com.example.kykkalanbakiye.model.Note
import com.example.kykkalanbakiye.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_add.*


class FragmentAdd : Fragment() {
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel= ViewModelProvider(this).get(NoteViewModel::class.java)

        addButton.setOnClickListener {
            val note=Note(0,editTextName.text.toString(),editTextBorc.text.toString().toDouble(),editTextOdaNo.text.toString().toInt())
            noteViewModel.addUser(note)
            Toast.makeText(requireContext(),"Not Eklendi", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_fragmentAdd_to_fragmentList)
        }

    }

}