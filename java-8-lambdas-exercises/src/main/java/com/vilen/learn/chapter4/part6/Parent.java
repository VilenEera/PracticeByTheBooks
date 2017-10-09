package com.vilen.learn.chapter4.part6;

/**
 * Created by vilen on 2017/10/9.
 */
public interface Parent {
    public void message(String body);

    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();
}
