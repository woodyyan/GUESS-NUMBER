package com.thoughtworks.guessnumber;

import com.thoughtworks.output.OutputConsole;
import com.thoughtworks.validator.GuessNumberGameValidator;

class GuessNumberGame {
    private Answer answer;
    private GuessNumberGameValidator validator;

    GuessNumberGame(GuessNumberGameValidator validator, Answer answer) {
        this.validator = validator;
        this.answer = answer;
    }

    GameResult play(Answer playerAnswer) {
        if (!validator.verify(playerAnswer.getNumbers())) {
            OutputConsole.getInstance().println("Guess number is not valid.");
        }

        return answer.compareTo(playerAnswer);
    }
}
