package com.deepskilling.exercise4;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AaaPatternTest {

    private int total;

    @Before
    public void setUp() {
        total = 10;
    }

    @Test
    public void shouldFollowArrangeActAssertPattern() {
        int addend = 5;

        int result = total + addend;

        assertEquals(15, result);
    }

    @After
    public void tearDown() {
        total = 0;
    }
}