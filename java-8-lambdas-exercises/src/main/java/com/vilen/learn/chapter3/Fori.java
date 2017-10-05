package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vilen on 2017/10/5.
 */
public class Fori {
    ArrayList<Artist> artistList = new ArrayList<Artist>(){{
        add(new Artist("披头士","London"));
        add(new Artist("Beyond","香港"));
        add(new Artist("博多之子","波兰"));
        add(new Artist("A","London"));
    }};

    public int listAll() {
        int count = 0;
        for (Artist artist : artistList) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        return count;
    }
    //外部迭代
    public int listAllByIterator() {
        int count = 0;
        Iterator<Artist> iterator = artistList.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        return count;
    }

    //内部迭代
    public int listAllByStream() {
        long count = artistList.stream().filter(artist -> artist.isFrom("London")).count();
        return (int)count;
    }

    //像filter 这样只描述Stream ，最终不产生新集合的方法叫作惰性求值方法
    public void listAllByStream1() {
        artistList.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");
        });
    }

    public void listAllByStream2() {
        artistList.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");
        }).count();
    }
}
