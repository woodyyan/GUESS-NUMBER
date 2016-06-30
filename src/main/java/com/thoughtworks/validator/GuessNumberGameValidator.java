package com.thoughtworks.validator;

import java.util.Arrays;

public class GuessNumberGameValidator extends NumberValidator {
    public final static int GAME_NUMBER_COUNT = 4;

    private final static int maxNumber = 9;
    private final static int minNumber = 0;

    @Override
    public boolean verify(Integer... numbers) {
        return checkNumberCountIsEqualGameNumberCount(numbers)
                && checkNumberCountIsNotDuplicated(numbers)
                && checkNumbersAreExceed(numbers);
    }

    private boolean checkNumberCountIsEqualGameNumberCount(Integer... numbers) {
        return numbers.length == GAME_NUMBER_COUNT;
    }

    private boolean checkNumberCountIsNotDuplicated(Integer... numbers) {
        return Arrays.stream(numbers).distinct().count() == GAME_NUMBER_COUNT;
    }

    private boolean checkNumbersAreExceed(Integer... numbers) {
        return Arrays.stream(numbers).allMatch(n -> n <= maxNumber && n >= minNumber);
    }
}
