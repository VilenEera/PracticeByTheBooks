package com.vilen.learn.chapter3;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/8.
 */
public class AdvancedExercisesTest {
    private <I, O> void assertMapped(Function<I, O> mapper, List<I> input, List<O> expectedOutput) {
        List<O> output = AdvancedExercises.map(input.stream(), mapper);
        assertEquals(expectedOutput, output);

        List<O> parallelOutput = AdvancedExercises.map(input.parallelStream(), mapper);
        assertEquals(expectedOutput, parallelOutput);
    }
    
    @Test
    public void emptyList() throws Exception {
        assertMapped(Function.<Object>identity(), Collections.<Object>emptyList(), Collections.emptyList());
    }

    @Test
    public void identityMapsToItself() throws Exception {
        assertMapped((Integer x) -> x,asList(1,2,3),asList(1,2,3));
    }

    @Test
    public void incrementingNumbers() throws Exception {
        assertMapped((Integer x) -> x+2,asList(1,2,3),asList(3,4,5));
    }

    //--------------------------------------------------//
    private <I> void assertFiltered(Predicate<I> predicate, List<I> input, List<I> expectedOutput) {
        List<I> output = AdvancedExercises.filter(input.stream(), predicate);
        assertEquals(expectedOutput, output);

        List<I> parallelOutput = AdvancedExercises.filter(input.parallelStream(), predicate);
        assertEquals(expectedOutput, parallelOutput);
    }


    @Test
    public void emptyListFilter() {
        assertFiltered(x -> false, Collections.<Object>emptyList(), Collections.<Object>emptyList());
    }

    @Test
    public void trueReturnsEverything() {
        assertFiltered((Integer x) -> true, asList(1, 2, 3), asList(1, 2, 3));
    }

    @Test
    public void falseRemovesEverything() {
        assertFiltered((Integer x) -> false, asList(1, 2, 3), asList());
    }

    @Test
    public void filterPartOfList() {
        assertFiltered((Integer x) -> x > 2, asList(1, 2, 3), asList(3));
    }
}