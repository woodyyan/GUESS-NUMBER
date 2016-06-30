package com.thoughtworks.guessnumber;

import com.thoughtworks.input.InputConsole;

import java.util.*;

class Player {
    Answer guess() {

        InputConsole console = new InputConsole();
        String numberString = console.getInputString();

        List<Integer> result = new ArrayList<>();
        String spaceChar = " ";
        String[] numbers = numberString.split(spaceChar);
        for (String stringNumber : numbers) {
            int number = Integer.parseInt(stringNumber);
            result.add(number);
        }

        return new Answer(result.toArray(new Integer[result.size()]));
    }
}
