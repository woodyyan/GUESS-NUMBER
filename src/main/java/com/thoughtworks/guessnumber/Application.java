package com.thoughtworks.guessnumber;

import com.thoughtworks.output.OutputConsole;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();

        GuessNumberGame game = new GuessNumberGame();
        game.start(player);
        GameResult gameResult = game.getGameResult();
        printGameResult(gameResult);
    }

    private static void printGameResult(GameResult result) {

        String message = result.getIsSuccessful() ? "Game over, you win!" : "Game over, you lose!";

        OutputConsole outputConsole = new OutputConsole();
        outputConsole.println(message);
    }
}
