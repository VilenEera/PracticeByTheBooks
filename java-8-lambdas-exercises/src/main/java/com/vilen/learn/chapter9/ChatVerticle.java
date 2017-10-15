package com.vilen.learn.chapter9;

import io.vertx.core.*;
import io.vertx.core.logging.LoggerFactory;

/**
 * Created by vilen on 2017/10/15.
 */
public class ChatVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        vertx.createNetServer()
                .connectHandler(netSocket -> {
                    LoggerFactory.getLogger(ChatVerticle.class).debug("socket connected");
                    //netSocket.handler(new User(netSocket, this));
                }).listen(10_000);
        LoggerFactory.getLogger(ChatVerticle.class).debug("ChatVerticle started");
        System.out.println("abc");
    }
}
