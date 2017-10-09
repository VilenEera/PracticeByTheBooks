package com.vilen.learn.chapter4.part6;

/**
 * Created by vilen on 2017/10/9.
 */
public interface Child extends Parent {
    @Override
    public default void welcome() {
        message("Child: Hi!");
    }
}
