package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.SampleData;
import com.vilen.learn.chapter1.Track;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
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

    @Test
    public void testMaxAndMinB() throws Exception {
        List<Track> tracks = asList(
                new Track("Bakai",524),
                new Track("Violets for Your Furs",378),
                new Track("Time Was",451));
        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }
        assertEquals(tracks.get(1),shortestTrack);
    }

    @Test
    public void testReduce() throws Exception {
        // 传入Stream 中的当前元素和acc 。将两个参数相加，acc 是累加器
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        assertEquals(6,count);
    }

    // 函数式编程
    @Test
    public void testReduceB() throws Exception {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count = accumulator.apply(accumulator.apply(accumulator.apply(0,1),2),3);
        assertEquals(6,count);
    }

    // 命令式编程
    @Test
    public void testReduceC() throws Exception {
        int acc = 0;
        for (Integer element : asList(1, 2, 3)) {
            acc = acc + element;
        }
        assertEquals(6,acc);
    }


    /**
     * 整合操作
     * 找出某张专辑上所有乐队的国籍
     * 分解
         * 1. 找出专辑上的所有表演者。
         2. 分辨出哪些表演者是乐队。
         3. 找出每个乐队的国籍。
         4. 将找出的国籍放入一个集合。
     1. Album 类有个getMusicians 方法，该方法返回一个Stream 对象，包含整张专辑中所有的表演者；
     2. 使用filter 方法对表演者进行过滤，只保留乐队；
     3. 使用map 方法将乐队映射为其所属国家；
     4. 使用collect(Collectors.toList()) 方法将国籍放入一个列表。
     */
    @Test
    public void testAll() throws Exception {
        Decisions decisions = new Decisions();
        Set<String> originsOfBands = decisions.originsOfBands(SampleData.aa);
        for (String originsOfBand : originsOfBands) {
            System.out.println(originsOfBand);
        }
    }
}
