package com.thoughtworks.guessnumber;

public class Application {

    public static void main(String[] args) {

        Player player = new Player();

        GuessNumberGame game = new GuessNumberGame();
        game.start(player);
    }
}
