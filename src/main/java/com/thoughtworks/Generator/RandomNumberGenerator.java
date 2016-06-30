package com.thoughtworks.Generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {
    public Integer[] generate(int count) {
        Random random = new Random();
        Integer maxNumber = 10;
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < count) {
            int index = random.nextInt(maxNumber);
            numberSet.add(index);
        }

        return numberSet.toArray(new Integer[count]);
    }
}
