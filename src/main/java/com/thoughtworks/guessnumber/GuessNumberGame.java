package com.thoughtworks.guessnumber;

import com.sun.xml.internal.xsom.util.DeferedCollection;

import java.security.InvalidParameterException;
import java.util.*;

class GuessNumberGame {
    private final static int maxAnswerCount = 6;

    private Integer[] answer;
    private int answerCount = 0;

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

        int aNumberCount = 0;
        int bNumberCount = 0;
        int numberCount = 4;
        for (int i = 0; i < numberCount; i++) {
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

        result.setMessageType(MessageType.Pending);
        result.setNumberCorrectCount(aNumberCount);
        result.setLocationCorrectCount(bNumberCount);
        return result;
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

    private void checkNumberIsValid(Integer[] numbers) throws Exception {
        int maxNumber = 9;
        int minNumber = 0;
        if (numbers.length != 4
                || Arrays.stream(numbers).distinct().count() < 4
                || Arrays.stream(numbers).anyMatch(n -> n > maxNumber || n < minNumber)) {
            throw new InvalidParameterException("Numbers should be not duplicated.");
        }
    }
}
