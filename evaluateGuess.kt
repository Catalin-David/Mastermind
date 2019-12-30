package mastermind

import java.lang.Math.min

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    // Idea: count all the common letters and the letters that are in the right position.
    // To find wrongPosition, simply subtract rightPosition from all the common letters.

    val rightPositions = secret.zip(guess).count{it.first == it.second}

    val commonLetters = "ABCDEF".sumBy { ch -> min(secret.count{it == ch}, guess.count{it==ch}) }

    return Evaluation(rightPositions, commonLetters - rightPositions)
}
