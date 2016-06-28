package com.thoughtworks.guessnumber;

import java.util.*;

class Player {
    Integer[] answer() {

        Scanner scanner = new Scanner(System.in);
        String numbersString = scanner.nextLine();

        List<Integer> result = new ArrayList<>();
        String[] numbers = numbersString.split(" ");
        int firstNumber = Integer.parseInt(numbers[0]);
        int secondNumber = Integer.parseInt(numbers[1]);
        int thirdNumber = Integer.parseInt(numbers[2]);
        int fourthNumber = Integer.parseInt(numbers[3]);
        result.add(firstNumber);
        result.add(secondNumber);
        result.add(thirdNumber);
        result.add(fourthNumber);

        return result.toArray(new Integer[result.size()]);
    }
}
