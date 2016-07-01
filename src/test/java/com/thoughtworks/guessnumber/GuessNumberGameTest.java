package com.thoughtworks.guessnumber;

import com.thoughtworks.Generator.RandomNumberGenerator;
import com.thoughtworks.validator.GuessNumberGameValidator;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {
    @Test
    public void name() {
        //given
        Player player = mock(Player.class);
        Answer answer = new Answer(Arrays.asList(1, 2, 3, 4));
        when(player.guess()).thenReturn(answer);

        RandomNumberGenerator generator = mock(RandomNumberGenerator.class);
        when(generator.generate(4)).thenReturn(Arrays.asList(1, 2, 3, 5));

        //when
        GuessNumberGameValidator validator = new GuessNumberGameValidator();
        GuessNumberGame game = new GuessNumberGame(validator, generator);
        GameResult result = game.play(player.guess());

        //then
        assertThat(result.getIsSuccessful(), is(false));
    }
}
