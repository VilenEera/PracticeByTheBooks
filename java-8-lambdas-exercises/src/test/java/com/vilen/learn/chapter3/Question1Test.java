package com.vilen.learn.chapter3;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/7.
 */
public class Question1Test {
    @Test
    public void testAddUp() throws Exception {
        int result = Question1.addUp(Stream.empty());
        assertEquals(0,result);
        int result2 = Question1.addUp(Stream.of(1, 2, 3));
        assertEquals(6,result2);
    }
}