package com.vilen.learn.chapter9;

import io.vertx.core.Vertx;

/**
 * Created by vilen on 2017/10/15.
 */
public class App {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(ChatVerticle.class.getName());
    }
}
