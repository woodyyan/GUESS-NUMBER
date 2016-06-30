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

        GameResult result = new GameResult();
        result.setNumberCorrectCount(numberCorrectCount);
        result.setLocationCorrectCount(locationCorrectCount);
        if (numberCorrectCount == numbers.size()) {
            result.setIsSuccessful(true);
        }

        return result;
    }
}
