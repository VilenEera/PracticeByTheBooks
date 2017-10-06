package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Artist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by vilen on 2017/10/6.
 */
public class Decisions {
    public static class Imperative{
        public Set<String> originsOfBands(Album album) {
            Set<String> nationalities = new HashSet<>();
            for (Artist artist : album.getMusicianList()) {
                if (artist.getName().startsWith("The")) {
                    String nationality = artist.getNationality();
                    nationalities.add(nationality);
                }
            }
            return nationalities;
        }
    }

    public Set<String> originsOfBands(Album album) {
        Set<String> origins = album
                .getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());
        return origins;
    }

    // 不提倡的
    public Set<String> originsOfBandsMisuse(Album album) {
        List<Artist> musicians = album.getMusicians().collect(Collectors.toList());
        List<Artist> bands = musicians.stream().filter(artist -> artist.getName().startsWith("The"))
                .collect(Collectors.toList());
        Set<String> origins = bands.stream().map(artist -> artist.getNationality())
                .collect(Collectors.toSet());
        return origins;
    }
}
