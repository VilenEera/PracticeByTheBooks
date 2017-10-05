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
}