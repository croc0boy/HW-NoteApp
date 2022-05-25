package uz.direction.noteapp

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.direction.noteapp.databinding.FragmentFirstPageBinding


class FirstPage : Fragment(R.layout.fragment_first_page) {
    private var binding: FragmentFirstPageBinding? = null
    private val args by navArgs<FirstPageArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.text)
        val title = view.findViewById<TextView>(R.id.title)
        view.findViewById<ImageButton>(R.id.button_edit).setOnClickListener {
            val action = FirstPageDirections.actionFirstPageToEditPage(
                text = text.text.toString(),
                title = title.text.toString()
            )
            findNavController().navigate(action)
        }
        text.text = args.textChanged
        title.text = args.titleChanged

        val sharedPreferences = activity?.getSharedPreferences(
            getString(R.string.shared_pref_key),
            Context.MODE_PRIVATE
        )
        binding?.title?.text =
            sharedPreferences?.getString(getString(R.string.title), "Write title here!")
        binding?.text?.text =
            sharedPreferences?.getString(getString(R.string.text), "Write text here!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("fragmentKey") { fragmentKey, bundle ->
            binding?.text?.text = bundle.getString("text")
            binding?.title?.text = bundle.getString("title")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstPageBinding.inflate(layoutInflater)
        return binding!!.root
    }
}