package com.vilen.learn.chapter3;

import java.util.stream.Stream;

/**
 * Created by vilen on 2017/10/7.
 */
public class Question1 {
    // 求和函数
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }
}
