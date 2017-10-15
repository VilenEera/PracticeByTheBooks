package com.vilen.learn.chapter7;

import com.vilen.learn.chapter1.Album;

import java.util.List;

/**
 * Created by vilen on 2017/10/15.
 */public abstract class Order {

    protected final List<Album> albums;

    public Order(List<Album> albums) {
        this.albums = albums;
    }

    public abstract long countRunningTime();

    public abstract long countMusicians();

    public abstract long countTracks();

}
