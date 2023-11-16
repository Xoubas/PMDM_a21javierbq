package com.example.ud6_3_guessgame

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val words = arrayListOf<String>("Patata", "Tomate", "Lechuga", "Puerro")
    var secretWord: String = words.random().uppercase()

}