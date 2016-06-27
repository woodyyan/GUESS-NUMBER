package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BoxContainerTest {
    @Test
    public void shouldReturnTrueIfTwoContainerAreEqual() {
        //given

        //when
        boolean result = false;

        //then
        Assert.assertThat(result, is(true));
    }
}
