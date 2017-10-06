package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Track;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by vilen on 2017/10/6.
 */
public class CollectTest {
    @Test
    public void test(){
        List<String> collected = Stream.of("a","b","c")
                .collect(Collectors.toList());
        assertEquals(asList("a", "b", "c"), collected);
    }

    @Test
    public void testMap() {
        List<String> collected = new ArrayList<>();
        for (String string : asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testMapB() {
        List<String> collected = Stream.of("a","b","hello")
                .map(string -> string.toUpperCase()).collect(Collectors.toList());
        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testFilter() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : asList("a", "1abc", "abc1")) {
            if (isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }
        assertEquals(asList("1abc"), beginningWithNumbers);
    }

    @Test
    public void testFilterB() {
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0))).collect(Collectors.toList());
        assertEquals(asList("1abc"), beginningWithNumbers);
    }

    @Test
    public void testFlatMap() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        assertEquals(asList(1,2,3,4),together);
    }

    @Test
    public void testMaxAndMin() throws Exception {
        List<Track> tracks = asList(new Track("Bakai",524),
                new Track("Violets for Your Furs",378),
                new Track("Time Was",451));
        Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength()))
                .get();
        assertEquals(tracks.get(1),shortestTrack);

    }
}
