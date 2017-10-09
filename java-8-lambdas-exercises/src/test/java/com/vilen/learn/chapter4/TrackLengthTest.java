package com.vilen.learn.chapter4;

import com.vilen.learn.chapter1.SampleData;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/9.
 */
public class TrackLengthTest {
    @Test
    public void testLengthStatus() throws Exception {
        TrackLength.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }
}