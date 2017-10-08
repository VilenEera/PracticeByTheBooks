package com.vilen.learn.chapter3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/8.
 */
public class StringExercisesTest {
    @Test
    public void testNoLowercaseLettersInAnEmptyString() throws Exception {
        assertEquals(0,StringExercises.countLowercaseLetters(""));
    }

    @Test
    public void testCountsLowercaseLetterExample() throws Exception {
        assertEquals(3,StringExercises.countLowercaseLetters("aBcDeF"));
    }

    @Test
    public void testNoLowercaseLetters() throws Exception {
        assertEquals(0,StringExercises.countLowercaseLetters("ABCDEF"));
    }

    @Test
    public void testNoStringReturnedForEmptyList() throws Exception {
        assertFalse(StringExercises.mostLowercaseString(Collections.<String>emptyList()).isPresent());
    }

    @Test
    public void testFindsMostLowercaseString() throws Exception {
        Optional<String> result = StringExercises.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        assertEquals(Optional.of("abc"),result);
    }
}