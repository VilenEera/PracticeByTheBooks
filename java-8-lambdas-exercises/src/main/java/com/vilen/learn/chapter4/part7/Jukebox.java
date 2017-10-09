package com.vilen.learn.chapter4.part7;

/**
 * Created by vilen on 2017/10/9.
 */
public interface Jukebox {
    public default String rock() {
        return "... all over the world!";
    }
}
