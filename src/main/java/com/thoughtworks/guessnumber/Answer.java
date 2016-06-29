package com.thoughtworks.guessnumber;

import java.util.Arrays;

class Answer {
    private Integer[] numbers;

    Integer[] getNumbers() {
        return numbers;
    }

    Answer(Integer... numbers) {
        this.numbers = numbers;
    }

    GameResult compareTo(Answer anotherAnswer) {
        GameResult result = new GameResult();

        int numberCorrectCount = 0;
        int locationCorrectCount = 0;
        Integer[] anotherNumbers = anotherAnswer.getNumbers();
        for (int i = 0; i < 4; i++) {
            if (numbers[i].equals(anotherNumbers[i])) {
                numberCorrectCount++;
            } else {
                Integer number = numbers[i];
                Integer answerNumber = anotherNumbers[i];
                if (Arrays.stream(anotherNumbers).filter(f -> !f.equals(answerNumber)).anyMatch(number::equals)) {
                    locationCorrectCount++;
                }
            }
        }

        result.setNumberCorrectCount(numberCorrectCount);
        result.setLocationCorrectCount(locationCorrectCount);
        if(numberCorrectCount == 4){
            result.setIsSuccessful(true);
        }

        return result;
    }
}
