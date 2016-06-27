package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoxTest {

    @Test
    public void shouldReturnNumberAndLocationtWhenTwoBoxesAreEqual() {
        //given
        Box answerBox = new Box(1, Location.First);

        //when
        Location location = Location.First;
        Box box = new Box(1, location);
        CompareResult result = box.Compare(answerBox);

        //then
        assertThat(CompareResult.NumberAndLocation, is(result));
    }
}
