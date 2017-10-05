package com.vilen.learn.chapter2;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/5.
 */
public class TestThreadLocalTest {
    @Test
    public void test() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String formatted = TestThreadLocal.formatter.get().getFormat().format(cal.getTime());
        assertEquals("01-一月-1970", formatted);
    }

    @Test
    public void testa() {
        Runnable hello = () -> System.out.println(1);
        hello.run();
    }

    @Test
    public void testa1() {
        Runnable hello = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        hello.run();
    }
}