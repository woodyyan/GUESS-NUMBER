package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class GameTest {
    @Test
    public void should_return_1A0B_when_answer_is_1234_and_input_number_is_1567() {
        //given

        //when

        //then
        String result = null;
        Assert.assertThat(result, is("1A0B"));
    }
}
