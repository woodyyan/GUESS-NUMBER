package com.thoughtworks.guessnumber;

import com.google.inject.Inject;
import com.thoughtworks.Generator.RandomNumberGenerator;
import com.thoughtworks.output.OutputConsole;
import com.thoughtworks.validator.GuessNumberGameValidator;

class GuessNumberGame {
    private static final int GAME_NUMBER_COUNT = 4;

    private Answer answer;
    private GuessNumberGameValidator validator;

    @Inject
    GuessNumberGame(GuessNumberGameValidator validator, RandomNumberGenerator generator) {
        this.validator = validator;
        answer = new Answer(generator.generate(GAME_NUMBER_COUNT));
    }

    Answer getAnswer() {
        return answer;
    }

    GameResult play(Answer playerAnswer) {
        if (!validator.verify(playerAnswer.getNumbers())) {
            OutputConsole.getInstance().println("Guess number is not valid.");
            return null;
        }

        return answer.compareTo(playerAnswer);
    }
}
