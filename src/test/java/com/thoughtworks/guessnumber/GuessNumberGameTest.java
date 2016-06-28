package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GuessNumberGameTest {
    @Test
    public void should_return_1A0B_when_answer_is_1234_and_input_number_is_1567() {
        //given
        Integer[] numbers = {1, 5, 6, 7};

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        guessNumberGame.setAnswer(1, 2, 3, 4);
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("1A0B"));
    }

    @Test
    public void should_return_4A0B_when_answer_is_1234_and_input_number_is_1234() {
        //given
        Integer[] numbers = {1, 2, 3, 4};

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        guessNumberGame.setAnswer(1, 2, 3, 4);
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_return_0A2B_when_answer_is_1234_and_input_number_is_2478() {
        //given
        Integer[] numbers = {2, 4, 7, 8};

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        guessNumberGame.setAnswer(1, 2, 3, 4);
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("0A2B"));
    }
}
