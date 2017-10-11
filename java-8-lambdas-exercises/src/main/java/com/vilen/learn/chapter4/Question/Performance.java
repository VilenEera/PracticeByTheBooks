package com.vilen.learn.chapter4.Question;

import com.vilen.learn.chapter1.Artist;

import java.util.stream.Stream;

/**
 * Created by vilen on 2017/10/11.
 */
public interface Performance {
    public String getName();

    public Stream<Artist> getMusicians();

    //添加getAllMusicians 方法，该方法返回包含所有艺术家名字的Stream ，如果对象是乐队，则返回每个乐队成员的名字。
    // 例如，如果getMusicians 方法返回甲壳虫乐队，则getAllMusicians 方法返回乐队名和乐队成员
    public default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    }
}
