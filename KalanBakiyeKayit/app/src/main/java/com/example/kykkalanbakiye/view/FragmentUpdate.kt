package com.example.kykkalanbakiye.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kykkalanbakiye.R
import com.example.kykkalanbakiye.model.Note
import com.example.kykkalanbakiye.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.editTextBorc
import kotlinx.android.synthetic.main.fragment_update.editTextName
import kotlinx.android.synthetic.main.fragment_update.editTextOdaNo


class FragmentUpdate : Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    private val args by navArgs<FragmentUpdateArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel=ViewModelProvider(this).get(NoteViewModel::class.java)
        editTextName.setText(args.argsID.adSoyad)
        editTextBorc.setText(args.argsID.borc.toString())
        editTextOdaNo.setText(args.argsID.odaNo.toString())
        updateutton.setOnClickListener {
            val note= Note(0,editTextName.text.toString(),editTextBorc.text.toString().toDouble(),editTextOdaNo.text.toString().toInt())
            noteViewModel.updateUser(note)
            Toast.makeText(requireContext(),"Not Güncellendi", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_fragmentUpdate_to_fragmentList)
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.menu_delete){
            val builder=AlertDialog.Builder(requireContext())
            builder.setTitle("${args.argsID.adSoyad} Mi Silinecek ?")
            builder.setMessage("${args.argsID.adSoyad} Silinecek Emin Misiniz ?")
            builder.setPositiveButton("Evet"){_,_->
                noteViewModel.deleteUser(args.argsID)
                Toast.makeText(requireContext(),"${args.argsID.adSoyad} İsimli Kullanıcı Silindi",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_fragmentUpdate_to_fragmentList)
            }
            builder.setNegativeButton("Hayır"){_,_->

            }
            builder.create().show()
        }
        return super.onOptionsItemSelected(item)
    }


}