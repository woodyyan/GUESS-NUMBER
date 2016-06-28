package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PlayerTest {
    @Test
    public void should_return_a_valid_result_when_answer() {
        //given
        Player player = new Player();

        //when
        Integer[] result = player.answer();

        //then
        assertThat(result.length, is(4));
    }
}
