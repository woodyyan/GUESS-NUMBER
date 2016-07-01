package com.thoughtworks.guessnumber;

import com.google.inject.Inject;
import com.thoughtworks.input.InputConsole;

import java.util.*;

class Player {
    private InputConsole console;

    @Inject
    Player(InputConsole console) {
        this.console = console;
    }

    Answer guess() {
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
