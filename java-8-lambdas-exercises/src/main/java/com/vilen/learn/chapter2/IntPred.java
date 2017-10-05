package com.vilen.learn.chapter2;

import java.util.function.Predicate;

/**
 * Created by vilen on 2017/10/5.
 */
public interface IntPred {
    boolean test(Integer value);

    boolean check(Predicate<Integer> predicate);

    boolean check(IntPred predicate);
}
