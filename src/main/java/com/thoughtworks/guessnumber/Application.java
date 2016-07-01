package com.thoughtworks.guessnumber;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thoughtworks.module.GameModule;
import com.thoughtworks.output.OutputConsole;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new GameModule());
        GuessNumberGame game = injector.getInstance(GuessNumberGame.class);
        Player player = injector.getInstance(Player.class);

        GameResult gameResult = null;
        for (int i = 0; i < 8; i++) {
            Answer answer = player.guess();
            gameResult = game.play(answer);
            if (gameResult != null) {
                OutputConsole.getInstance().println(gameResult.getMessage());
                if (gameResult.getIsSuccessful()) {
                    break;
                }
            }
        }

        printGameResult(gameResult, game.getAnswer());
    }

    private static void printGameResult(GameResult result, Answer answer) {
        List<Integer> numbers = answer.getNumbers();
        String answerString = "";
        for (Integer number : numbers) {
            answerString += number.toString();
        }

        String message = result.getIsSuccessful() ? "Game over, you win!" : "Game over, you lose! Answer is: " + answerString;

        OutputConsole.getInstance().println(message);
    }
}
