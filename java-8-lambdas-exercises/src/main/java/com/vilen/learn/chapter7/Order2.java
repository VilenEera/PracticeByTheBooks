package com.vilen.learn.chapter7;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Track;

import java.util.List;

/**
 * 计算用户购买专辑的一些有用属性，
 * 如计算音乐家人数、曲目和专辑时长
 * Created by vilen on 2017/10/13.
 */
public class Order2 {
    public long countRunningTime(List<Album> albums) {
        long count = 0;
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                count += track.getLength();
            }
        }
        return count;
    }

    public long countMusicians(List<Album> albums) {
        long count = 0;
        for (Album album : albums) {
            count += album.getMusicianList().size();
        }
        return count;
    }

    public long countTracks(List<Album> albums) {
        long count = 0;
        for (Album album : albums) {
            count += album.getTrackList().size();
        }
        return count;
    }
}
