package com.thoughtworks.guessnumber;

import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Player player = new Player();

        GuessNumberGame game = new GuessNumberGame();
        game.start(player);
    }
}
