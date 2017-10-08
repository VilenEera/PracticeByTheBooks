package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Artist;

import java.util.List;

/**
 * Created by vilen on 2017/10/7.
 */
public class Question2 {
    public static int countBandMembersInternal(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getMembers().count())
                .reduce(0L, (x, y) -> x + y)
                .intValue();
    }

    public static int countBandMembersInternalB(List<Artist> artists) {
        return (int) artists.stream().flatMap(artist -> artist.getMembers()).count();
    }
}
