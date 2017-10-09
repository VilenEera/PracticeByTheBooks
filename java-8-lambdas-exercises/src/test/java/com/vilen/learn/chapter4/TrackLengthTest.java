package com.vilen.learn.chapter4;

import com.vilen.learn.chapter1.SampleData;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/9.
 */
public class TrackLengthTest {
    @Test
    public void testLengthStatus() throws Exception {
        TrackLength.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }

    @Test
    public void testOverload() throws Exception {
        TrackLength trackLength = new TrackLength();
        trackLength.overloadedMethod("abc"); // String
    }

    @Test
    public void testOverloadMethod() throws Exception {
        TrackLength trackLength = new TrackLength();
        trackLength.overloadedMethod((x,y) -> x+y); //IntegerBinaryOperator
    }

    @Test
    public void testOverloadedPredicate() throws Exception {
        TrackLength trackLength = new TrackLength();
        // 出错
        // trackLength.overloadedMethod((x) -> true);
        // 下面这个虽然可以,但是不建议使用,
        // “代码异味”，不该再重载，而应当开始重新命名重载方法
        trackLength.overloadedMethod((TrackLength.IntPredicate) (x) -> true);
    }
}