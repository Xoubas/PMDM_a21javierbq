package com.example.ud6_3_guessgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val words = arrayListOf<String>("Patata", "Tomate", "Lechuga", "Puerro")
    var secretWord: String = words.random().uppercase()

    //Displayed word
//    var secretWordDisplay: String = ""
    var secretWordDisplay = MutableLiveData<String>()

    //Number of lives
//    var lives = 5
    var lives = MutableLiveData<Int>()

    //Intentos de usuario
    var guesses = mutableListOf<Char>()

    init {
        secretWordDisplay.value = generateWordDisplay()
    }

    fun generateWordDisplay() =
        secretWord.map {
            if (it in guesses) it
            else "_"
        }.joinToString("")

    fun game(guess: Char) {
        guesses.add(guess.uppercaseChar())
        secretWordDisplay.value = generateWordDisplay()
        if (!secretWord.contains(guess.uppercaseChar())) lives.value?.minus(1)
    }

    fun win() = secretWord.equals(secretWordDisplay)
    fun lost() = lives.value ?: 0 <= 0

    fun resultMessage() =
        if (win()) "Ganaste, la palabra secreta era $secretWord"
        else "Te equivocaste, la palabra era $secretWord"

    fun restart() {
        guesses.clear()
        lives.value = 5
        secretWord = words.random().uppercase()
    }
}