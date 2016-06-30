package com.thoughtworks.validator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberValidatorTest {
    @Test
    public void should_return_false_when_input_number_is_1123() {
        //given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));

        //when
        GuessNumberGameValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }

    @Test
    public void should_return_false_when_input_number_is_12() {
        //given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2));

        //when
        GuessNumberGameValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }

    @Test
    public void should_return_false_when_input_number_is_more_than_9() {
        //given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(10, 1, 2, 3));

        //when
        GuessNumberGameValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }
}
