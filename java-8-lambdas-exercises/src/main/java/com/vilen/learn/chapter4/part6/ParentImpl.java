package com.vilen.learn.chapter4.part6;

/**
 * Created by vilen on 2017/10/9.
 */
public class ParentImpl implements Parent {

    private String body;

    @Override
    public void message(String body) {
        this.body = body;
    }

    @Override
    public String getLastMessage() {
        return body;
    }
}
