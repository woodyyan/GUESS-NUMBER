package com.thoughtworks.guessnumber;

import java.util.Arrays;

class GuessNumberGame {
    private Integer[] answer;

    String getResult(Integer... numbers) {
        if (Arrays.equals(answer, numbers)) {
            return "4A0B";
        }

        int aNumberCount = 0;
        int bNumberCount = 0;
        for (int i = 0; i < 4; i++) {
            if (numbers[i].equals(answer[i])) {
                aNumberCount++;
            } else if (i < 3) {
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
}
