package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

public class GameConsoleTest {
    @Test
    public void shouldReturn4A0BWhenNumberIs1234() {
        //given
        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(1, Location.First));
        boxes.add(new Box(2, Location.Second));
        boxes.add(new Box(3, Location.Third));
        boxes.add(new Box(4, Location.Fourth));
        BoxContainer boxContainer = new BoxContainer(boxes);

        //when
        Set<Box> answerBoxes = new HashSet<>();
        answerBoxes.add(new Box(1, Location.First));
        answerBoxes.add(new Box(2, Location.Second));
        answerBoxes.add(new Box(3, Location.Third));
        answerBoxes.add(new Box(4, Location.Fourth));
        BoxContainer answer = new BoxContainer(answerBoxes);
        GameConsole gameConsole = new GameConsole(answer);
        String result = gameConsole.getAnswer(boxContainer);

        //then
        Assert.assertThat(result, is("4A0B"));
    }

    @Test
    public void shouldReturnAValidBoxContainer() {
        //given

        //when

        //then
        
    }
}
