package com.vilen.learn.chapter2;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

/**
 * Created by vilen on 2017/10/5.
 */
public class TestThreadLocal {
    public final static ThreadLocal<DateFormatter> formatter =
            ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
}
