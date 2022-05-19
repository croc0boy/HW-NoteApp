package uz.direction.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class FirstPage : Fragment(R.layout.fragment_first_page) {

    private val args by navArgs<FirstPageArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.text)
        val title = view.findViewById<TextView>(R.id.title)
        view.findViewById<ImageButton>(R.id.button_edit).setOnClickListener {
        val action = FirstPageDirections.actionFirstPageToEditPage(
            text = text.text.toString(),
            title = title.text.toString())
            findNavController().navigate(action)
        }

        text.text = args.textChanged
        title.text = args.titleChanged
    }


}