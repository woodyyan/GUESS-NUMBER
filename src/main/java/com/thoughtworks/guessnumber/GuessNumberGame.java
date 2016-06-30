package com.thoughtworks.guessnumber;

import com.thoughtworks.Generator.RandomNumberGenerator;
import com.thoughtworks.output.OutputConsole;
import com.thoughtworks.validator.GuessNumberGameValidator;

class GuessNumberGame {
    private final static int maxAnswerCount = 8;

    private Answer answer;
    private OutputConsole outputConsole;
    private GuessNumberGameValidator validator;

    GuessNumberGame() {
        outputConsole = new OutputConsole();
        validator = new GuessNumberGameValidator();
        RandomNumberGenerator generator = new RandomNumberGenerator();
        answer = new Answer(generator.generate(GuessNumberGameValidator.GAME_NUMBER_COUNT));
    }

    void start(Player player) {
        GameResult result = new GameResult();
        for (int i = 0; i < maxAnswerCount; i++) {
            Answer playerAnswer = player.guess();
            if (!validator.verify(playerAnswer.getNumbers())) {
                outputConsole.println("Guess number is not valid.");
                continue;
            }

            result = answer.compareTo(playerAnswer);
            outputConsole.println(result.getMessage());
            if (result.getIsSuccessful()) {
                break;
            }
        }

        printGameResult(result);
    }

    private void printGameResult(GameResult result) {
        String answerString = "";
        for (Integer number : answer.getNumbers()) {
            answerString += number;
        }
        String message = result.getIsSuccessful() ? "Game over, you win!" : "Game over, you lose! Answer is " + answerString;
        outputConsole.println(message);
    }
}
