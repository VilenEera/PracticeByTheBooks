package com.vilen.learn.chapter6;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.SampleData;
import com.vilen.learn.chapter1.Track;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.Main;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

 /**
  * http://blog.csdn.net/hotdust/article/details/72643696
  * http://blog.dyngr.com/blog/2016/10/29/introduction-of-jmh/
 * Created by vilen on 2017/10/13.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class ArraySum1 {
    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {
                ".*ArraySum.*",
                "-wi",
                "5",
                "-i",
                "5"
        };
        Main.main(args);
    }

    public List<Album> albums;

    @Setup
    public void initAlbums() {
        int n = Integer.getInteger("arraysum.size", 1000000);
        albums = IntStream.range(0,n)
                .mapToObj(i -> SampleData.aLoveSupreme.copy())
                .collect(Collectors.toList());
    }

    @Benchmark
    public int serialArraySum() {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    @Benchmark
    public int parallelArraySum() {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }
     /*
     # Run complete. Total time: 00:04:04
     Benchmark                   Mode  Cnt  Score    Error  Units
     ArraySum1.parallelArraySum  avgt   50  0.019 ±  0.001   s/op
     ArraySum1.serialArraySum    avgt   50  0.046 ±  0.001   s/op
     */
}
