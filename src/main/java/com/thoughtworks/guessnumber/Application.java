package com.thoughtworks.guessnumber;

import com.thoughtworks.Generator.RandomNumberGenerator;
import com.thoughtworks.input.InputConsole;
import com.thoughtworks.output.OutputConsole;
import com.thoughtworks.validator.GuessNumberGameValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Answer gameAnswer = getRandomGameAnswer();

        Player player = new Player();
        GuessNumberGame game = new GuessNumberGame(new GuessNumberGameValidator(), gameAnswer);

        GameResult gameResult = null;
        for (int i = 0; i < 8; i++) {
            Answer answer = player.guess(new InputConsole());
            gameResult = game.play(answer);
            if (gameResult != null) {
                OutputConsole.getInstance().println(gameResult.getMessage());
                if (gameResult.getIsSuccessful()) {
                    break;
                }
            }
        }

        printGameResult(gameResult, gameAnswer);
    }

    private static Answer getRandomGameAnswer() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        List<Integer> numbers = generator.generate(4);
        return new Answer(numbers);
    }

    private static void printGameResult(GameResult result, Answer answer) {
        String answerString = "";
        for (Integer number : answer.getNumbers()) {
            answerString += number;
        }
        String message = result.getIsSuccessful() ? "Game over, you win!" : "Game over, you lose! Answer is: " + answerString;

        OutputConsole.getInstance().println(message);
    }
}
