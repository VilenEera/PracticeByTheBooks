package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.SampleData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/7.
 */
public class Question1Test {
    @Test
    public void testAddUp() throws Exception {
        int result = Question1.addUp(Stream.empty());
        assertEquals(0,result);
        int result2 = Question1.addUp(Stream.of(1, 2, 3));
        assertEquals(6,result2);
    }

    @Test
    public void testAddsListWithValues() throws Exception {
        int result = Question1.addUp(Stream.of(1, 3, -2));
        assertEquals(2,result);
    }

    @Test
    public void testExtractsNamesAndOriginsOfArtists() throws Exception {
        List<String> namesAndOrigins = Question1.getNamesAndOrigins(SampleData.getThreeArtists());
        assertEquals(asList("John Coltrane","US","John Lennon","UK","The Beatles","UK"),namesAndOrigins);
    }

    @Test
    public void testFindsAlbums() throws Exception {
        List<Album> input = asList(SampleData.manyTrackAlbum, SampleData.sampleShortAlbum, SampleData.aLoveSupreme);
        List<Album> result = Question1.getAlbumsWithAtMostThreeTracks(input);
        assertEquals(asList(SampleData.sampleShortAlbum,SampleData.aLoveSupreme),result);
    }
}