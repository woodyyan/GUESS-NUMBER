package com.thoughtworks.guessnumber;

import com.thoughtworks.Generator.RandomNumberGenerator;
import com.thoughtworks.output.OutputConsole;
import com.thoughtworks.validator.GuessNumberGameValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        RandomNumberGenerator generator = new RandomNumberGenerator();
        List<Integer> numbers = generator.generate(4);
        Answer gameAnswer = new Answer(numbers);

        Player player = new Player();
        Answer answer = player.guess();

        GuessNumberGame game = new GuessNumberGame(new GuessNumberGameValidator(), gameAnswer);
        GameResult gameResult = game.play(answer);

        printGameResult(gameResult, gameAnswer);
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
