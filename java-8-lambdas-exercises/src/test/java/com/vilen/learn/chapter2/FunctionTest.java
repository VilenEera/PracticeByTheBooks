package com.vilen.learn.chapter2;

import org.junit.Test;

/**
 * Created by vilen on 2017/10/5.
 */
public class FunctionTest {
    @Test
    public void test() {
        Function<Long,Long> function = x->x+1;
        System.out.println(function.apply(10L));
    }
}
