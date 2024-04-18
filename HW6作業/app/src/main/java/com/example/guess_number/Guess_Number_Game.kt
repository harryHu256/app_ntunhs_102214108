package com.example.guess_number

import  java.util.*

class Guess_Number_Game {

    private var secret: Int = Random().nextInt(100) + 1
    private var minNum = 1
    private var maxNum = 100
    fun guess(guess: Int): String {
        return when {
            guess == secret -> "恭喜猜對了!"
            guess > secret -> {
                maxNum = guess - 1
                "猜的太大了 !  " +
                        "範圍:$minNum ~ $maxNum"
            }
            else -> {
                minNum = guess + 1
                "猜的太小了 ! " +
                        " 範圍:$minNum ~ $maxNum"
            }
        }
    }
    fun reset() {
        secret = Random().nextInt(100) + 1
        minNum = 1
        maxNum = 100
    }
}

