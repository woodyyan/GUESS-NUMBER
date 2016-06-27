package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

public class BoxContainerTest {
    @Test
    public void shouldReturn1A1BIfOneContainerIs1234OtherContainerIs1456() {
        //given
        Set<Box> otherBoxes = new HashSet<>();
        otherBoxes.add(new Box(1, Location.First));
        otherBoxes.add(new Box(4, Location.Second));
        otherBoxes.add(new Box(5, Location.Third));
        otherBoxes.add(new Box(6, Location.First));
        BoxContainer otherContainer = new BoxContainer(otherBoxes);

        //when
        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(1, Location.First));
        boxes.add(new Box(2, Location.Second));
        boxes.add(new Box(3, Location.Third));
        boxes.add(new Box(4, Location.First));
        BoxContainer boxContainer = new BoxContainer(boxes);
        String result = boxContainer.getResult(otherContainer);

        //then
        Assert.assertThat(result, is("1A1B"));
    }
}
