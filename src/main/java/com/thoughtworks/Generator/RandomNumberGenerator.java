package com.thoughtworks.Generator;

import java.util.*;

public class RandomNumberGenerator {
    public List<Integer> generate(int count) {
        Random random = new Random();
        Integer maxNumber = 10;
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < count) {
            int index = random.nextInt(maxNumber);
            numberSet.add(index);
        }

        return new ArrayList<>(numberSet);
    }
}
