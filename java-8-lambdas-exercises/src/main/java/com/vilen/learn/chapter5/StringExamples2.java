package com.vilen.learn.chapter5;

import com.vilen.learn.chapter1.Artist;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by vilen on 2017/10/12.
 */
public class StringExamples2 {
    public static String formatArtists(List<Artist> artists) {
        String result = artists.stream()
                .map(Artist::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        return result;
    }

    public static String formatArtistsForLoop(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1) {
                builder.append(",");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();
        return result;
    }
    // 开始重构

    public static String formatArtistsRefactor1(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        artists.stream()
                .map(Artist::getName)
                .forEach(name -> {
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append(name);
                });
        builder.append("]");
        String result = builder.toString();
        return result;
    }

    public static String formatArtistsRefactor2(List<Artist> artists) {
        StringBuilder reduces = artists.stream()
                .map(Artist::getName)
                .reduce(new StringBuilder(),(stringBuilder,name) ->{
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(name);
                    return stringBuilder;
                },(left,right) -> left.append(right));
        reduces.insert(0, "[");
        reduces.append("]");
        String result = reduces.toString();
        return result;
    }
    //使用一个StringCombiner 类对细节进行抽象
    //连接姓名操作被代理到了StringCombiner.add 方法，
    // 而连接两个连接器操作被StringCombiner.merge 方法代理
    public static String formatArtistsRefactor3(List<Artist> artists) {
        StringCombiner combiner = artists.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(", ", "[", "]"),
                        StringCombiner::add, StringCombiner::merge);
        String result = combiner.toString();
        return result;
    }

    public static String formatArtistsRefactor4(List<Artist> artists) {
        String result = artists.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(", ", "[", "]")
                        , StringCombiner::add, StringCombiner::merge).toString();
        return result;
    }

    public static String formatArtistsRefactor5(List<Artist> artists) {
        String result = artists.stream()
                .map(Artist::getName)
                .collect(new StringCollector(", ", "[", "]"));
        return result;
    }

    //区别在于Collectors.reducing 的第二个参数，我们为流中每个元素创建了唯一的StringCombiner 。
    //如果你被这种写法吓到了，或是感到恶心，你不是一个人！这种方式非常低效，这也是我要定制收集器的原因之一。
    public static String formatArtistsReducing(List<Artist> artists) {
        String result = artists.stream()
                .map(Artist::getName)
                .collect(Collectors.reducing(
                        new StringCombiner(",", "[", "]"),
                        name -> new StringCombiner(",","[","]").add(name),
                        StringCombiner::merge
                )).toString();
        return result;
    }

}
