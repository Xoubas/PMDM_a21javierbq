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
import com.example.ud6_3_guessgame.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
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
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.txtResult.text = gameModel.resultMessage()
        val view = binding.root
        binding.buttonNewGame.setOnClickListener {
            gameModel.restart()
            view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
//            Toast.makeText(context, gameModel.secretWord, Toast.LENGTH_LONG).show()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}