package uz.direction.noteapp.mvvm.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.direction.noteapp.R
import uz.direction.noteapp.databinding.FragmentNoteBinding

class NoteFragment : Fragment(R.layout.fragment_note) {
    private val binding by viewBinding(FragmentNoteBinding::bind)
    private val args by navArgs<NoteFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}