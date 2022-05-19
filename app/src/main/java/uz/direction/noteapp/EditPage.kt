package uz.direction.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class EditPage : Fragment(R.layout.fragment_edit_page) {

    private val args by navArgs<EditPageArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textEdit = view.findViewById<EditText>(R.id.text)
        val titleEdit = view.findViewById<EditText>(R.id.title)

        view.findViewById<ImageButton>(R.id.button_done).setOnClickListener {
            val action = EditPageDirections.actionEditPageToFirstPage(
                textChanged = textEdit.text.toString(),
                titleChanged = titleEdit.text.toString()
            )

            findNavController().navigate(action)
        }
        textEdit.setText(args.text)
        titleEdit.setText(args.title)




    }



}