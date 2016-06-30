package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnswerTest {

    private Answer answer;

    @Before
    public void setUp() {
        answer = new Answer(Arrays.asList(1, 2, 3, 4));
    }

    @Test
    public void should_return_1A0B_when_answer_is_1234_and_input_number_is_1567() {
        //given
        List<Integer> numbers = Arrays.asList(1, 5, 6, 7);

        //when
        GameResult result = answer.compareTo(new Answer(numbers));

        //then
        assertThat(result.getMessage(), is("1A0B"));
    }

    @Test
    public void should_return_4A0B_when_answer_is_1234_and_input_number_is_1234() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //when
        GameResult result = answer.compareTo(new Answer(numbers));

        //then
        assertThat(result.getMessage(), is("4A0B"));
    }

    @Test
    public void should_return_0A2B_when_answer_is_1234_and_input_number_is_2478() {
        //given
        List<Integer> numbers = Arrays.asList(2, 4, 7, 8);

        //when
        GameResult result = answer.compareTo(new Answer(numbers));

        //then
        assertThat(result.getMessage(), is("0A2B"));
    }

    @Test
    public void should_return_1A2B_when_answer_is_1234_and_input_number_is_0324() {
        //given
        List<Integer> numbers = Arrays.asList(0, 3, 2, 4);

        //when
        GameResult result = answer.compareTo(new Answer(numbers));

        //then
        assertThat(result.getMessage(), is("1A2B"));
    }

    @Test
    public void should_return_0A0B_when_answer_is_1234_and_input_number_is_5678() {
        //given
        List<Integer> numbers = Arrays.asList(5, 6, 7, 8);

        //when
        GameResult result = answer.compareTo(new Answer(numbers));

        //then
        assertThat(result.getMessage(), is("0A0B"));
    }

    @Test
    public void should_return_0A4B_when_answer_is_1234_and_input_number_is_4321() {
        //given
        List<Integer> numbers = Arrays.asList(4, 3, 2, 1);

        //when
        GameResult result = answer.compareTo(new Answer(numbers));

        //then
        assertThat(result.getMessage(), is("0A4B"));
    }
}
