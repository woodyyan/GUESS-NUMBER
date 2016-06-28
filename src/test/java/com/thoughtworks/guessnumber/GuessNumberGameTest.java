package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GuessNumberGameTest {

    private GuessNumberGame guessNumberGame;

    @Before
    public void setUp() {
        guessNumberGame = new GuessNumberGame();
        guessNumberGame.setAnswer(1, 2, 3, 4);
    }

    @Test
    public void should_return_1A0B_when_answer_is_1234_and_input_number_is_1567() {
        //given
        Integer[] numbers = {1, 5, 6, 7};

        //when
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("1A0B"));
    }

    @Test
    public void should_return_4A0B_when_answer_is_1234_and_input_number_is_1234() {
        //given
        Integer[] numbers = {1, 2, 3, 4};

        //when
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_return_0A2B_when_answer_is_1234_and_input_number_is_2478() {
        //given
        Integer[] numbers = {2, 4, 7, 8};

        //when
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("0A2B"));
    }

    @Test
    public void should_return_1A2B_when_answer_is_1234_and_input_number_is_0324() {
        //given
        Integer[] numbers = {0, 3, 2, 4};

        //when
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("1A2B"));
    }

    @Test
    public void should_return_0A0B_when_answer_is_1234_and_input_number_is_5678() {
        //given
        Integer[] numbers = {5, 6, 7, 8};

        //when
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("0A0B"));
    }

    @Test
    public void should_return_0A4B_when_answer_is_1234_and_input_number_is_4321() {
        //given
        Integer[] numbers = {4, 3, 2, 1};

        //when
        String result = guessNumberGame.getResult(numbers);

        //then
        assertThat(result, is("0A4B"));
    }
}
