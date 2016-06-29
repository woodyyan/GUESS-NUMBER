package com.thoughtworks.guessnumber;

import java.util.Arrays;

class GuessNumberGameValidator extends NumberValidator {
    private final static int gameNumberCount = 4;
    private final static int maxNumber = 9;
    private final static int minNumber = 0;

    int getGameNumberCount() {
        return gameNumberCount;
    }

    @Override
    boolean verify(Integer... numbers) {
        return checkNumberCountIsEqualGameNumberCount(numbers)
                && checkNumberCountIsNotDuplicated(numbers)
                && checkNumbersAreExceed(numbers);
    }

    private boolean checkNumberCountIsEqualGameNumberCount(Integer... numbers) {
        return numbers.length == gameNumberCount;
    }

    private boolean checkNumberCountIsNotDuplicated(Integer... numbers) {
        return Arrays.stream(numbers).distinct().count() == gameNumberCount;
    }

    private boolean checkNumbersAreExceed(Integer... numbers) {
        return Arrays.stream(numbers).allMatch(n -> n <= maxNumber && n >= minNumber);
    }
}
