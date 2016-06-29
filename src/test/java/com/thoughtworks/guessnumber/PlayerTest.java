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
        Answer answer = player.guess();

        //then
        assertThat(answer.getNumbers().length, is(4));
    }
}
