package com.vilen.learn.chapter4.Question;

import com.vilen.learn.chapter1.Artist;
import com.vilen.learn.chapter1.SampleData;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.security.cert.PKIXRevocationChecker;
import java.util.Optional;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by vilen on 2017/10/12.
 */
public class ArtistsTest {
    private final ArtistsFixed optionalExamples = new ArtistsFixed(SampleData.getThreeArtists());

    @Test
    public void indexWithinRange() {
        Optional<Artist> artist = optionalExamples.getArtist(0);
        assertThat(true, CoreMatchers.is(artist.isPresent()));
    }

    @Test
    public void indexOutsideRange() {
        Optional<Artist> artist = optionalExamples.getArtist(4);
        assertThat(false,CoreMatchers.is(artist.isPresent()));
    }

    @Test
    public void nameIndexInsideRange() {
        String artist = optionalExamples.getArtistName(0);
        assertThat("John Coltrane",CoreMatchers.is(artist));
    }

    @Test
    public void nameIndexOutsideRange() {
        String artist = optionalExamples.getArtistName(4);
        assertThat("unknown",CoreMatchers.is(artist));
    }

}
