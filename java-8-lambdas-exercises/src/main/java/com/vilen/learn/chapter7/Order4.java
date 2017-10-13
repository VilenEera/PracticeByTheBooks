package com.vilen.learn.chapter7;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Track;

import java.util.List;
import java.util.function.ToLongFunction;

/**
 * 因为有一些抽象和共性只能使用领域内的知识来表达。流不会提供一个方法统计每张专辑上的信息——这是程序员要自己编写的领域知识。
 * 这也是在Java 8出现之前很难编写的领域方法，因为每个方法都不一样。
 * Created by vilen on 2017/10/13.
 */
public class Order4 {

    public long countFeature(List<Album> albums,ToLongFunction<Album> function) {
        return albums.stream().mapToLong(function)
                .sum();
    }

    public long countRunningTime(List<Album> albums) {
//        long count = 0;
//        for (Album album : albums) {
//            for (Track track : album.getTrackList()) {
//                count += track.getLength();
//            }
//        }
//        return count;
//        return albums.stream().mapToLong(album -> album.getTracks()
//                .mapToLong(Track::getLength).sum()).sum();
        return countFeature(albums, album -> album.getTracks().count());
    }

    public long countMusicians(List<Album> albums) {
//        long count = 0;
//        for (Album album : albums) {
//            count += album.getMusicianList().size();
//        }
//        return count;
//        return albums.stream().mapToLong(album -> album.getMusicians().count()).sum();
        return countFeature(albums, value -> value.getTracks().mapToLong(Track::getLength).sum());
    }

    public long countTracks(List<Album> albums) {
//        long count = 0;
//        for (Album album : albums) {
//            count += album.getTrackList().size();
//        }
//        return count;
//        return albums.stream().mapToLong(album -> album.getTracks().count()).sum();
        return countFeature(albums, value -> value.getMusicians().count());
    }
}
