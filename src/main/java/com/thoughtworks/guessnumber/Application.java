package com.thoughtworks.guessnumber;

public class Application {

    public static void main(String[] args) {
        Integer[] answer = GuessNumberGame.generateRandomNumbers();

        GuessNumberGame game = new GuessNumberGame();
        game.setAnswer(answer);

        Player player = new Player();

        boolean isFinished = false;
        while (!isFinished) {
            Integer[] numbers = player.guess();
            try {
                GameResult result = game.play(numbers);
                System.out.println(result.toString());
                if (!result.getMessageType().equals(MessageType.Pending)) {
                    isFinished = true;
                }
            } catch (Exception ex) {
                isFinished = true;
                System.out.println(ex.getMessage());
            }
        }

        for (Integer number : answer) {
            System.out.print(number + " ");
        }
    }
}
