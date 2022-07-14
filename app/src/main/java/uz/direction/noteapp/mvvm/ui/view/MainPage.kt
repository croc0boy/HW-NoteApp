package uz.direction.noteapp.mvvm.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.FragmentMainPageBinding
import uz.direction.noteapp.mvvm.model.Note
import uz.direction.noteapp.mvvm.ui.adapter.NoteAdapter
import uz.direction.noteapp.mvvm.ui.viewmodel.MainScreenViewModel
import uz.direction.noteapp.mvvm.util.ViewModelFactory

class MainPage : Fragment(R.layout.fragment_main_page) {
    private val noteViewModel by viewModels<MainScreenViewModel> {
        ViewModelFactory()
    }
    private var notes: List<Note> = ArrayList()
    private val binding by viewBinding(FragmentMainPageBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel.getAllNotes()

        lifecycleScope.launchWhenCreated {
            noteViewModel.dataFlow.collect { notes ->
                val noteAdapter = NoteAdapter(notes) { position ->
                    onItemClick(position)
                }
                binding.recycleViewer.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = noteAdapter
                }
            }
        }
    }

    private fun onItemClick(position: Int) {
        val action = MainPageDirections.actionMainPageToNoteFragment(note = notes[position])
        findNavController().navigate(action)
    }
}