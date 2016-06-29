package com.thoughtworks.guessnumber;

import java.util.*;

class Player {
    Answer guess() {

        Scanner scanner = new Scanner(System.in);
        String numbersString = scanner.nextLine();

        List<Integer> result = new ArrayList<>();
        String spaceChar = " ";
        String[] numbers = numbersString.split(spaceChar);
        for (String stringNumber : numbers) {
            int number = Integer.parseInt(stringNumber);
            result.add(number);
        }

        return new Answer(result.toArray(new Integer[result.size()]));
    }
}
