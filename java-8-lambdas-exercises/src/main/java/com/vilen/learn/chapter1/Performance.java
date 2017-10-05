package com.vilen.learn.chapter1;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * Created by vilen on 2017/10/5.
 */
public interface Performance {
    public String getName();

    public Stream<Artist> getMusicians();

    // TODO: test
    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> {
            return concat(Stream.of(artist), artist.getMembers());
        });
    }
}
