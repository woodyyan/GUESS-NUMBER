package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberValidatorTest {
    @Test
    public void should_return_false_when_input_number_is_1123() {
        //given
        Integer[] numbers = {1, 1, 2, 3};

        //when
        NumberValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }

    @Test
    public void should_return_false_when_input_number_is_12() {
        //given
        Integer[] numbers = {1, 2};

        //when
        NumberValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }

    @Test
    public void should_return_false_when_input_number_is_more_than_9() {
        //given
        Integer[] numbers = {10, 2, 3, 4};

        //when
        NumberValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }
}
