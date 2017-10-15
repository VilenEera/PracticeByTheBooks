package com.vilen.learn.chapter7;

import com.vilen.learn.chapter1.Album;

import java.util.List;
import java.util.function.ToLongFunction;

/**
 * Created by vilen on 2017/10/15.
 */
public class OrderDomain extends Order {
    public OrderDomain(List<Album> albums) {
        super(albums);
    }

    public long countFeature(ToLongFunction<Album> function){
        return albums.stream().mapToLong(function)
                .sum();
    }

    @Override
    public long countRunningTime() {
        return countFeature(value -> value.getTracks()
                .mapToLong(value1 -> value1.getLength()).sum());
    }

    @Override
    public long countMusicians() {
        return countFeature(album -> album.getMusicians().count());
    }

    @Override
    public long countTracks() {
        return countFeature(album -> album.getTracks().count());
    }
}
