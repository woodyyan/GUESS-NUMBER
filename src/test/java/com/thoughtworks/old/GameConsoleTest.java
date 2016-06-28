package com.thoughtworks.old;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;

public class GameConsoleTest {
    @Test
    public void shouldReturn4A0BWhenNumberIs1234() {
        //given
        BoxContainer answer = new BoxContainer("1 2 3 4");

        //when
        GameConsole gameConsole = new GameConsole();
        String result = gameConsole.guessNumber(answer);

        //then
        Assert.assertThat(result, not("4A0B"));
    }

    @Test
    public void shouldReturnAValidBoxContainer() {
        //given
        GameConsole console = new GameConsole();

        //when
        String result = console.getAnswer();


        //then
        Assert.assertThat(result, not("1234"));
    }
}
