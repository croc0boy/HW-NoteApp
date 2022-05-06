package com.example.notes


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(R.layout.fragment_second) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTv = view.findViewById<TextView>(R.id.title_note)
        val titleArg = requireArguments().get("title") as String

        val textTv = view.findViewById<TextView>(R.id.text_note)
        val textArg = requireArguments().get("text") as String

        titleTv.text =  titleArg
        textTv.text =  textArg

        titleTv.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }

}