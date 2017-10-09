package com.vilen.learn.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/9.
 */
public class LoggerTest {
    @Test
    public void testMethod() throws Exception {
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: " + "~~");
    }
}