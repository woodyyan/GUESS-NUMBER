package com.thoughtworks.guessnumber;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class GuessNumberGame {
    private Integer[] answer;
    private int answerCount = 0;

    String getResult(Integer... numbers) {
        checkNumberIsValid(numbers);

        answerCount++;
        if (answerCount > 6) {
            return "Failed";
        }

        if (Arrays.equals(answer, numbers)) {
            return "4A0B";
        }

        int aNumberCount = 0;
        int bNumberCount = 0;
        for (int i = 0; i < 4; i++) {
            if (numbers[i].equals(answer[i])) {
                aNumberCount++;
            } else {
                Integer number = numbers[i];
                Integer answerNumber = answer[i];
                if (Arrays.stream(answer).filter(f -> !f.equals(answerNumber)).anyMatch(number::equals)) {
                    bNumberCount++;
                }
            }
        }

        return aNumberCount + "A" + bNumberCount + "B";
    }

    void setAnswer(Integer... numbers) {
        this.answer = numbers;
    }

    static Integer[] generateRandomNumber() {
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

        return new Integer[]{firstNumber, secondNumber, thirdNumber, fourthNumber};
    }

    private void checkNumberIsValid(Integer[] numbers) {
        int maxNumber = 9;
        int minNumber = 0;
        if (numbers.length != 4
                || Arrays.stream(numbers).distinct().count() < 4
                || Arrays.stream(numbers).anyMatch(n -> n > maxNumber || n < minNumber)) {
            throw new InvalidParameterException("Numbers should be not duplicated.");
        }
    }
}
