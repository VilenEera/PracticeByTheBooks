package com.vilen.learn.chapter7;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Track;

import java.util.List;

/**
 * Created by vilen on 2017/10/13.
 */
public class Order3 {
    public long countRunningTime(List<Album> albums) {
//        long count = 0;
//        for (Album album : albums) {
//            for (Track track : album.getTrackList()) {
//                count += track.getLength();
//            }
//        }
//        return count;
        return albums.stream().mapToLong(album -> album.getTracks()
                .mapToLong(Track::getLength).sum()).sum();
    }

    public long countMusicians(List<Album> albums) {
//        long count = 0;
//        for (Album album : albums) {
//            count += album.getMusicianList().size();
//        }
//        return count;
        return albums.stream().mapToLong(album -> album.getMusicians().count()).sum();
    }

    public long countTracks(List<Album> albums) {
//        long count = 0;
//        for (Album album : albums) {
//            count += album.getTrackList().size();
//        }
//        return count;
        return albums.stream().mapToLong(album -> album.getTracks().count()).sum();
    }
}
