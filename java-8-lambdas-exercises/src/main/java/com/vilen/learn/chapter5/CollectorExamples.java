package com.vilen.learn.chapter5;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Artist;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by vilen on 2017/10/12.
 */
public class CollectorExamples {
    public void toCollectionTreeset() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.collect(toCollection(TreeSet::new));
    }

    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(maxBy(Comparator.comparing(getCount)));
    }

    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }

    public Map<Boolean,List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
    }

    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician));
    }
    /**_------*/
    public Map<Artist, Integer> numberOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(Album::getMainMusician));
        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }
        return numberOfAlbums;
    }

    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician,counting()));
    }
    /**_------*/
    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(Album::getMainMusician));
        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue().stream().map(Album::getName).collect(Collectors.toList()));
        }
        return nameOfAlbums;
    }

    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician, mapping(Album::getName, toList())));
    }
    /**_------*/
    public static Map<String, Long> countWords(Stream<String> words) {
        return words.collect(groupingBy(word -> word, counting()));
    }

    private static final Pattern SPACES = Pattern.compile("\\w+");

    public static Map<String,Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, Charset.defaultCharset()).stream()
                .flatMap(line -> SPACES.splitAsStream(line));
        return countWords(words);
    }

    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(averagingInt(album -> album.getTrackList().size()));
    }
}
