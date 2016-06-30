package com.thoughtworks.guessnumber;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void should_return_a_valid_result_when_answer() {
        //given
        Player player = mock(Player.class);

        //when
        Answer answer = new Answer(Arrays.asList(1, 2, 3, 4));
        when(player.guess()).thenReturn(answer);
        Answer playerAnswer = player.guess();

        //then
        assertThat(playerAnswer.getNumbers().size(), is(4));
    }
}
