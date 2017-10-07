package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Artist;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vilen on 2017/10/7.
 */
public class Question1 {
    // 求和函数
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }
    // 编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的姓名和国籍；
    public static List<String> getNamesAndOrigins(List<Artist> artists){
        return artists.stream().flatMap(artist -> Stream.of(artist.getName(),artist.getNationality()))
                .collect(Collectors.toList());
    }

    // 接受专辑列表作为参数，返回一个由最多包含3首歌曲的专辑组成的列表
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream().filter(album -> album.getTrackList().size() <= 3).collect(Collectors.toList());
    }
}
