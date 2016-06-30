package com.thoughtworks.guessnumber;

import com.thoughtworks.Generator.RandomNumberGenerator;
import com.thoughtworks.output.OutputConsole;
import com.thoughtworks.validator.GuessNumberGameValidator;

class GuessNumberGame {
    private final static int maxAnswerCount = 8;

    private Answer answer;
    private GameResult gameResult;
    private GuessNumberGameValidator validator;

    GameResult getGameResult() {
        return gameResult;
    }

    GuessNumberGame() {
        gameResult = new GameResult(false, 0, 0);
        validator = new GuessNumberGameValidator();
        RandomNumberGenerator generator = new RandomNumberGenerator();
        answer = new Answer(generator.generate(GuessNumberGameValidator.GAME_NUMBER_COUNT));
    }

    void start(Player player) {
        OutputConsole outputConsole = new OutputConsole();

        for (int i = 0; i < maxAnswerCount; i++) {
            if (playARound(player, outputConsole)) continue;
            outputConsole.println(gameResult.getMessage());
            if (gameResult.getIsSuccessful()) {
                break;
            }
        }

        String answerString = "";
        for (Integer number : answer.getNumbers()) {
            answerString += number;
        }
        outputConsole.println("Answer is: " + answerString);
    }

    private boolean playARound(Player player, OutputConsole outputConsole) {
        Answer playerAnswer = player.guess();
        if (!validator.verify(playerAnswer.getNumbers())) {
            outputConsole.println("Guess number is not valid.");
            return true;
        }

        gameResult = answer.compareTo(playerAnswer);
        return false;
    }
}
