package com.thoughtworks.old;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BoxContainerTest {
    @Test
    public void shouldReturn1A1BIfOneContainerIs1234OtherContainerIs1456() {
        //given
        BoxContainer otherContainer = new BoxContainer("1 4 5 6");

        //when
        BoxContainer boxContainer = new BoxContainer("1 2 3 4");
        String result = boxContainer.getResult(otherContainer);

        //then
        Assert.assertThat(result, is("1A1B"));
    }
}
