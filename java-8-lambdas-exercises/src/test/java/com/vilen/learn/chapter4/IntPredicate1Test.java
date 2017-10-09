package com.vilen.learn.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/9.
 */
public class IntPredicate1Test {

    @Test
    public void testTest1() throws Exception {
        IntPredicate1Test.overloadedMethod((x) -> true);
    }

    public static void overloadedMethod(IntPredicate1 predicate) {
        System.out.println("Predicate");
    }
}