package com.vilen.learn.chapter4.part7;

/**
 * Created by vilen on 2017/10/9.
 */
public interface Carriage {
    public default String rock() {
        return "... from side to side";
    }
}
