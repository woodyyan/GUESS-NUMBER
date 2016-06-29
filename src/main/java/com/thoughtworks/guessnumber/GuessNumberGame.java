package com.thoughtworks.guessnumber;

class GuessNumberGame {
    private final int maxAnswerCount = 8;

    private Answer answer;
    private GuessNumberGameValidator validator;

    GuessNumberGame() {
        validator = new GuessNumberGameValidator();
        answer = new Answer(RandomNumberGenerator.generate(validator.getGameNumberCount()));
    }

    void start(Player player) {
        GameResult result = new GameResult();
        for (int i = 0; i < maxAnswerCount; i++) {
            Answer playerAnswer = player.guess();
            if (!validator.verify(playerAnswer.getNumbers())) {
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
        for (Integer number : answer.getNumbers()) {
            answerString += number;
        }
        String message = result.getIsSuccessful() ? "Game over, you win!" : "Game over, you lose! Answer is " + answerString;
        System.out.println(message);
    }
}
