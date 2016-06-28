package com.thoughtworks.guessnumber;

public class Application {

    public static void main(String[] args) {
        Integer[] answer = GuessNumberGame.generateRandomNumber();

        GuessNumberGame game = new GuessNumberGame();
        game.setAnswer(answer);

        Player player = new Player();

        boolean isFinished = false;
        while (!isFinished) {
            Integer[] numbers = player.answer();
            try {
                String result = game.getResult(numbers);
                System.out.println(result);
                if (result.equals("Failed") || result.equals("4A0B")) {
                    isFinished = true;
                }
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        }

        for (Integer number : answer) {
            System.out.print(number + " ");
        }
    }
}
