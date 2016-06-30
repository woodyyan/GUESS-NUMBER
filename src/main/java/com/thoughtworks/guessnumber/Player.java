package com.thoughtworks.guessnumber;

import com.thoughtworks.input.InputConsole;

import java.util.*;

class Player {
    Answer guess() {

        InputConsole console = new InputConsole();
        String numberString = console.getInputString();

        List<Integer> numbers = parseInputToSet(numberString);

        return new Answer(numbers);
    }

    private List<Integer> parseInputToSet(String input) {
        List<Integer> result = new ArrayList<>();
        String spaceChar = " ";
        String[] numbers = input.split(spaceChar);
        for (String stringNumber : numbers) {
            int number = Integer.parseInt(stringNumber);
            result.add(number);
        }
        return result;
    }
}
