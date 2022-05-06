package com.example.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.databinding.FragmentFirstBinding
import com.example.notes.SecondFragment as SecondFragment

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            passData(
                binding.mainTitle.text.toString(),
                binding.mainText.text.toString(),
            )
        }

    }
    fun passData(title: String, text: String) {
        val bundle = Bundle()
        bundle.putString("title", title)
        bundle.putString("text", text)
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                SecondFragment::class.java ,
                bundle
            )
            .setReorderingAllowed(true)
            .addToBackStack("")
            .commit()
    }



}