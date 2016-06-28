package com.thoughtworks.old;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Comparator.comparing;

class GameConsole {

    private final BoxContainer boxContainer;

    GameConsole() {
        String numberString = getNotDuplicatedRandomNumbers();
        this.boxContainer = new BoxContainer(numberString);
    }

    String guessNumber(BoxContainer boxContainer) {
        return this.boxContainer.getResult(boxContainer);
    }

    String getAnswer() {

        String answer = "";

        Object[] numbers = this.boxContainer.getBoxes().stream().sorted(comparing(Box::getLocation)).map(Box::getNumber).toArray();
        for (Object obj : numbers) {
            answer += obj;
        }

        return answer;
    }

    private String getNotDuplicatedRandomNumbers() {
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

        int index = random.nextInt(list.size());
        int firstNumber = list.get(index);
        list.remove(index);
        index = random.nextInt(list.size());
        int secondNumber = list.get(index);
        list.remove(index);
        index = random.nextInt(list.size());
        int thirdNumber = list.get(index);
        list.remove(index);
        index = random.nextInt(list.size());
        int fourthNumber = list.get(index);

        return firstNumber + " " + secondNumber + " " + thirdNumber + " " + fourthNumber;
    }
}
