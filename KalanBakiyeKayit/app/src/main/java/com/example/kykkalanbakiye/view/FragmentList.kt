package com.example.kykkalanbakiye.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kykkalanbakiye.R
import com.example.kykkalanbakiye.adapter.RecyclerAdapter
import com.example.kykkalanbakiye.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class FragmentList : Fragment() {
    private lateinit var noteViewModel:NoteViewModel
    private var recyclerAdapter=RecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel=ViewModelProvider(this).get(NoteViewModel::class.java)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerAdapter= RecyclerAdapter()
        recyclerView.adapter=recyclerAdapter
        addFabButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragmentList_to_fragmentAdd)
        }
        observer()
    }
    private fun observer(){

        searchButton.setOnClickListener {
            noteViewModel.searchNote(searchText.text.toString())
        }

        noteViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setData(it)
            if( it ==null){
                Toast.makeText(requireContext(),"Liste Boş",Toast.LENGTH_LONG).show()
            }

        })



    }



}