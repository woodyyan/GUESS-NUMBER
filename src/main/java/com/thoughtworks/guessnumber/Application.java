package com.thoughtworks.guessnumber;

public class Application {

    public static void main(String[] args) {

        BoxContainer answer = new BoxContainer("1 2 3 4");

        GameConsole console = new GameConsole();
        String numbers = console.getAnswer();
        System.out.println(numbers);

        String result = console.guessNumber(answer);
        System.out.println(result);
    }
}
