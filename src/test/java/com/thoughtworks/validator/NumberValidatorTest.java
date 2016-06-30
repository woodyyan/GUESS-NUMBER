package com.thoughtworks.validator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thoughtworks.module.GameModule;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberValidatorTest {
    @Test
    public void should_return_false_when_input_number_is_1123() {
        //given
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3);

        //when
        GuessNumberGameValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }

    @Test
    public void should_return_false_when_input_number_is_12() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2);

        //when
        GuessNumberGameValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }

    @Test
    public void should_return_false_when_input_number_is_more_than_9() {
        //given
        List<Integer> numbers = Arrays.asList(10, 1, 2, 3);

        //when
        GuessNumberGameValidator numberValidator = new GuessNumberGameValidator();
        boolean isValid = numberValidator.verify(numbers);

        //then
        assertThat(isValid, is(false));
    }

    @Test
    public void should_return_false_by_injector_when_input_number_is_more_than_9() {
        Injector injector = Guice.createInjector(new GameModule());
        GuessNumberGameValidator validator = injector.getInstance(GuessNumberGameValidator.class);

        List<Integer> numbers = Arrays.asList(10, 1, 2, 3);
        boolean isValid = validator.verify(numbers);
        assertThat(isValid, is(false));
    }
}
