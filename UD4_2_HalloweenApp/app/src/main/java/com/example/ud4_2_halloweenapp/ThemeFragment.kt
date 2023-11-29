package com.example.ud4_2_halloweenapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

class ThemeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val name: String = ThemeFragmentArgs.fromBundle(requireArguments()).name
        val view = inflater.inflate(R.layout.fragment_theme, container, false)

        temaCasa(view, name)
        temaBosque(view, name)
        return view
    }

    fun temaCasa(view: View, name: String) {
        val card = view.findViewById<CardView>(R.id.card1)
        card.setOnClickListener {
            view.findViewById<TextView>(R.id.titulo).text = getString(R.string.titulo_casa)
            view.findViewById<ImageView>(R.id.imagen).setImageResource(R.drawable.casa)
            view.findViewById<TextView>(R.id.texto).text = getString(R.string.texto_casa, name)
            view.findNavController().navigate(R.id.action_themeFragment2_to_taleFragment2)
        }
    }

    fun temaBosque(view: View, name: String) {
        val card = view.findViewById<CardView>(R.id.card2)
        card.setOnClickListener {
            view.findViewById<TextView>(R.id.titulo).text = getString(R.string.titulo_bosque)
            view.findViewById<ImageView>(R.id.imagen).setImageResource(R.drawable.bosque)
            view.findViewById<TextView>(R.id.texto).text = getString(R.string.texto_bosque, name)
            view.findNavController().navigate(R.id.action_themeFragment2_to_taleFragment2)
        }
    }
}