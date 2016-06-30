package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameResultTest {
    @Test
    public void should_return_4A0B_when_() {
        //given
        GameResult result = new GameResult();

        //when
        result.setLocationCorrectCount(0);
        result.setNumberCorrectCount(4);

        //then
        assertThat(result.getMessage(), is("4A0B"));
    }
}
