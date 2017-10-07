package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.SampleData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/7.
 */
public class RefactorTest {
    @Test
    public void testAllStringJoins() throws Exception {
        List<Supplier<Refactor.LongTrackFinder>> finders = Arrays.<Supplier<Refactor.LongTrackFinder>>asList(
                Refactor.Step0::new,
                Refactor.Step1::new,
                Refactor.Step2::new,
                Refactor.Step3::new,
                Refactor.Step4::new
        );

        List<Album> albums = Collections.unmodifiableList(asList(SampleData.aLoveSupreme, SampleData.sampleShortAlbum));
        List<Album> noTracks = Collections.unmodifiableList(asList(SampleData.sampleShortAlbum));

        finders.forEach(finder ->{
            System.out.println("Testing: " + finder.toString());
            Refactor.LongTrackFinder longTrackFinder = finder.get();
            Set<String> longTracks = longTrackFinder.findLongTracks(albums);
            assertEquals("[Acknowledgement, Resolution]", longTracks.toString());
            longTracks = longTrackFinder.findLongTracks(noTracks);
            assertTrue(longTracks.isEmpty());
        });
    }
}