package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

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
        Assert.assertThat(result, is("1A0B"));
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
        Assert.assertThat(result, is("4A0B"));
    }
}
