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
        for (int i = 0; i < maxAnswerCount; i++) {
            Answer playerAnswer = player.guess();
            if (!validator.verify(playerAnswer.getNumbers())) {
                OutputConsole.getInstance().println("Guess number is not valid.");
                continue;
            }
            gameResult = answer.compareTo(playerAnswer);
            OutputConsole.getInstance().println(gameResult.getMessage());
            if (gameResult.getIsSuccessful()) {
                break;
            }
        }

        printGameAnswer();
    }

    private void printGameAnswer() {
        String answerString = "";
        for (Integer number : answer.getNumbers()) {
            answerString += number;
        }
        OutputConsole.getInstance().println("Answer is: " + answerString);
    }
}
