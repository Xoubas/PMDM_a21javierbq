package com.example.ud4_2_halloweenapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.findNavController

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val start = view.findViewById<Button>(R.id.start_button)
        start.setOnClickListener {
            val message: String = view.findViewById<EditText>(R.id.name).text.toString()

            view.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToThemeFragment2(message))
        }
        return view
    }
}