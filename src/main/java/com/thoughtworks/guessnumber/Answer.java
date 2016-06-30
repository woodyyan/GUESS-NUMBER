package com.thoughtworks.guessnumber;

import java.util.List;

class Answer {
    private List<Integer> numbers;

    List<Integer> getNumbers() {
        return numbers;
    }

    Answer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    GameResult compareTo(Answer anotherAnswer) {
        int numberCorrectCount = 0;
        int locationCorrectCount = 0;
        List<Integer> anotherNumbers = anotherAnswer.getNumbers();

        for (Integer number : anotherNumbers) {
            boolean isACorrect = numbers.contains(number) && numbers.indexOf(number) == anotherNumbers.indexOf(number);
            boolean isBCorrect = numbers.contains(number) && numbers.indexOf(number) != anotherNumbers.indexOf(number);

            if (isACorrect) numberCorrectCount++;
            if (isBCorrect) locationCorrectCount++;
        }

        boolean isSuccessful = numberCorrectCount == numbers.size();

        return new GameResult(isSuccessful, numberCorrectCount, locationCorrectCount);
    }
}
