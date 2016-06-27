package com.thoughtworks.guessnumber;

public class Application {

    public static void main(String[] args) {

        GameConsole console = new GameConsole();
        String numbers = console.getAnswer();
        System.out.println("Answer is: " + numbers);

        int maxTurn = 6;
        for (int i = 0; i < maxTurn; i++) {
            java.util.Scanner sin = new java.util.Scanner(System.in);
            String numberString = sin.nextLine();
            BoxContainer answer = new BoxContainer(numberString);
            String result = console.guessNumber(answer);
            System.out.println(result);
            if (result.equals("4A0B")) {
                System.out.println("You win!");
                break;
            }
        }
    }
}
