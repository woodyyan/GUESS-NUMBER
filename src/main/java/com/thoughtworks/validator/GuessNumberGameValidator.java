package com.thoughtworks.validator;

import com.google.common.collect.Range;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuessNumberGameValidator {
    public final static int GAME_NUMBER_COUNT = 4;

    private final static int MaxNumber = 9;
    private final static int MinNumber = 0;

    public boolean verify(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        Range<Integer> range = Range.closed(MinNumber, MaxNumber);
        boolean isInRange = range.containsAll(numbers);
        boolean isEqualGameCount = set.size() == GAME_NUMBER_COUNT;
        return isEqualGameCount && isInRange;
    }
}
