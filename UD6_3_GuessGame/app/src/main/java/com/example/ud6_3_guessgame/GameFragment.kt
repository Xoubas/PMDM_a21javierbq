package com.example.ud6_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ud6_3_guessgame.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    /*
    If the model is already created, it doesn't create again when it generates,
    because it calls the MainActivity
    */
    val gameModel: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        updateScreen()
        binding.buttonNext.setOnClickListener {
            if (binding.txtGuess.text.length > 0) {
//                gameModel.secretWord = "Palabra de prueba"
                gameModel.game(binding.txtGuess.text.toString()[0])
                updateScreen()
                if (gameModel.win() || gameModel.lost())
                    view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)

            } else {
                Toast.makeText(context, "Introduce una letra", Toast.LENGTH_LONG).show()
            }
        }
        gameModel.lives.observe(
            viewLifecycleOwner,
            { newValue -> binding.txtLives.text = "Te quedan ${newValue} vidas" })
        gameModel.secretWordDisplay.observe(
            viewLifecycleOwner, { it -> binding.txtWord.text = it })
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun updateScreen() {
//        binding.txtWord.text = gameModel.secretWordDisplay.value
//        binding.txtLives.text = "Te quedan ${gameModel.lives} vidas"
    }
}