package com.vilen.learn.chapter4;

import java.util.function.Supplier;

/**
 * Created by vilen on 2017/10/8.
 */
public class Logger {
    private boolean debug = true;

    public boolean isDebugEnabled() {
        return debug;
    }

    public void debug(String message) {
        if (isDebugEnabled()) {
            System.out.println(message);
        }
    }

    public void example() {
        Logger logger = new Logger();
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this: " + expensiveOperation());
        }
    }

    private String expensiveOperation() {
        return "";
    }

    public void debug(Supplier<String> message) {
        if (isDebugEnabled()) {
            debug(message.get());
        }
    }

    public void exampleWithLambda() {
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: " + expensiveOperation());
    }
}
