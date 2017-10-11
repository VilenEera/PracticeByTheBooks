package com.vilen.learn.chapter4.Question;

import com.vilen.learn.chapter1.Artist;
import com.vilen.learn.chapter1.SampleData;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/11.
 */
public class PerformanceTest {

    @Test
    public void testGetAllMusicians() throws Exception {
        Performance stub = new Performance() {
            @Override
            public String getName() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Stream<Artist> getMusicians() {
                return Stream.of(SampleData.theBeatles);
            }
        };

        List<Artist> allMusicians = stub.getAllMusicians().collect(Collectors.toList());
        assertThat(allMusicians, CoreMatchers.hasItem(SampleData.theBeatles));
        assertThat(allMusicians, CoreMatchers.hasItems(SampleData.membersOfTheBeatles.toArray(new Artist[0])));
    }
}