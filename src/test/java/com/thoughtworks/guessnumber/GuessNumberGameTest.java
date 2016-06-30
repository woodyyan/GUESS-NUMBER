package com.thoughtworks.guessnumber;

import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {
    @Test
    public void name() {
        //given
        Player player = mock(Player.class);
        Answer answer = new Answer(Arrays.asList(1, 2, 3, 4));
        when(player.guess()).thenReturn(answer);

        //when
        GuessNumberGame game = new GuessNumberGame();
        game.start(player);

        //then
    }
}
