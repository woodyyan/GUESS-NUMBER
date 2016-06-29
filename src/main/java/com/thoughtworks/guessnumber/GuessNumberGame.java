package com.thoughtworks.guessnumber;

import java.util.Arrays;

class GuessNumberGame {
    private final static int maxAnswerCount = 6;
    private final static int gameNumberCount = 4;

    private Answer answer;

    GuessNumberGame() {
        answer = new Answer(RandomNumberGenerator.generate(gameNumberCount));
    }

    void start(Player player) {
        GameResult result = new GameResult();
        for (int i = 0; i < maxAnswerCount; i++) {
            Answer playerAnswer = player.guess();
            if (!IsValidAnswer(answer)) {
                System.out.println("Guess number is not valid.");
                continue;
            }

            result = answer.compareTo(playerAnswer);
            System.out.println(result.getMessage());
            if (result.getIsSuccessful()) {
                break;
            }
        }

        printGameResult(result);
    }

    private void printGameResult(GameResult result) {
        String answerString = "";
        for (Integer number :
                answer.getNumbers()) {
            answerString += number;
        }
        String message = result.getIsSuccessful() ? "Game over, you win!" : "Game over, you lose! Answer is " + answerString;
        System.out.println(message);
    }

    private boolean IsValidAnswer(Answer answer) {
        boolean isValid = true;
        int maxNumber = 9;
        int minNumber = 0;
        Integer[] numbers = answer.getNumbers();
        if (numbers.length != gameNumberCount) {
            isValid = false;
        } else if (Arrays.stream(numbers).distinct().count() < gameNumberCount) {
            isValid = false;
        } else if (Arrays.stream(numbers).anyMatch(n -> n > maxNumber || n < minNumber)) {
            isValid = false;
        }
        return isValid;
    }
}
