package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomNumberGenerator {
    static Integer[] generate(int count) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(list.size());
            int number = list.get(index);
            numbers.add(number);
            list.remove(index);
        }

        return numbers.toArray(new Integer[count]);
    }
}
