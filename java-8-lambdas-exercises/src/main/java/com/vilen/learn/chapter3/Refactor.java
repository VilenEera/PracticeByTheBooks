package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by vilen on 2017/10/6.
 */
public class Refactor {
    //找出长度大于1分钟的曲目
    public static interface LongTrackFinder{
        public Set<String> findLongTracks(List<Album> albums);
    }

    public static class Step0 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            for (Album album : albums) {
                for (Track track : album.getTrackList()) {
                    if (track.getLength() > 60) {
                        String name = track.getName();
                        trackNames.add(name);
                    }
                }
            }
            return trackNames;
        }
    }
    // forEach 代替 for 循环
    public static class Step1 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream().forEach(album -> {
                album.getTracks().forEach(track -> {
                    if (track.getLength() >60) {
                        String name = track.getName();
                        trackNames.add(name);
                    }
                });
            });
            return trackNames;
        }
    }
    // 找出满足某种条件的曲目是filter 的功能，
    // 得到曲目名称则可用map 达成，
    // 终结操作可使用forEach 方法将曲目名称加入一个集合。
    public static class Step2 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream().forEach(album -> {
                album.getTracks().filter(track -> track.getLength() > 60)
                        .map(track -> track.getName())
                        .forEach(name -> trackNames.add(name));
            });
            return trackNames;
        }
    }
    //任何时候想转化 或替代 代码，都该使用map 操作。
    //这里将使用比map 更复杂的flatMap 操作，
    // 把多个Stream 合并成一个Stream 并返回
    public static class Step3 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength()>60)
                    .map(track -> track.getName())
                    .forEach(name -> trackNames.add(name));
            return trackNames;
        }
    }
    //转换成使用流风格的代码。最初只是简单地使用流，但没有引入任何有用的流操作。
    //随后通过一系列重构，最终使代码更符合使用流的风格
    public static class Step4 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            return albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength()>60)
                    .map(track -> track.getName())
                    .collect(Collectors.toSet());
        }
    }
}
