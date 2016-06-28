package com.thoughtworks.guessnumber;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class GuessNumberGame {
    private final static int maxAnswerCount = 6;
    private final static int gameNumberCount = 4;

    private int answerCount;
    private Integer[] answer;

    GuessNumberGame() {
        answerCount = 0;
        answer = new Integer[]{};
    }

    void setAnswer(Integer... numbers) {
        this.answer = numbers;
    }

    GameResult getResult(Integer... numbers) throws Exception {
        checkNumberIsValid(numbers);

        GameResult result = new GameResult();

        answerCount++;

        if (answerCount > maxAnswerCount) {
            result.setMessageType(MessageType.Failed);
            return result;
        }

        if (Arrays.equals(answer, numbers)) {
            result.setMessageType(MessageType.Success);
            return result;
        }

        int numberCorrectCount = 0;
        int locationCorrectCount = 0;
        for (int i = 0; i < gameNumberCount; i++) {
            if (numbers[i].equals(answer[i])) {
                numberCorrectCount++;
            } else {
                Integer number = numbers[i];
                Integer answerNumber = answer[i];
                if (Arrays.stream(answer).filter(f -> !f.equals(answerNumber)).anyMatch(number::equals)) {
                    locationCorrectCount++;
                }
            }
        }

        result.setMessageType(MessageType.Pending);
        result.setNumberCorrectCount(numberCorrectCount);
        result.setLocationCorrectCount(locationCorrectCount);
        return result;
    }

    static Integer[] generateRandomNumbers() {
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

    private void checkNumberIsValid(Integer[] numbers) throws Exception {
        int maxNumber = 9;
        int minNumber = 0;
        if (numbers.length != gameNumberCount) {
            throw new InvalidParameterException("Numbers' count should be " + gameNumberCount);
        } else if (Arrays.stream(numbers).distinct().count() < gameNumberCount) {
            throw new InvalidParameterException("Numbers should not be duplicated.");
        } else if (Arrays.stream(numbers).anyMatch(n -> n > maxNumber || n < minNumber)) {
            throw new InvalidParameterException("Numbers should from " + minNumber + " to " + maxNumber);
        }
    }
}
