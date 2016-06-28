package com.thoughtworks.guessnumber;

import java.util.Arrays;

class GuessNumberGame {
    private Integer[] answer;

    String getResult(Integer[] numbers) {
        if (Arrays.equals(answer, numbers)) {
            return "4A0B";
        }

        int aNumberCount = 0;
        int bNumberCount = 0;

        return aNumberCount + "A" + bNumberCount + "B";
    }

    void setAnswer(Integer... numbers) {
        this.answer = numbers;
    }
}
