package com.vilen.learn.chapter3;

import com.vilen.learn.chapter1.SampleData;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/7.
 */
public class Question2Test {
    @Test
    public void testCountBandMembersInternal() throws Exception {
        assertEquals(4,Question2.countBandMembersInternal(Arrays.asList(SampleData.johnColtrane,SampleData.theBeatles)));
    }
    @Test
    public void testCountBandMembersInternalB() throws Exception {
        assertEquals(4,Question2.countBandMembersInternalB(Arrays.asList(SampleData.johnColtrane,SampleData.theBeatles)));
    }
}