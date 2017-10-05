package com.vilen.learn.chapter3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/5.
 */
public class ForiTest {
    @Test
    public void testListAll() {
        Fori fori = new Fori();
        assertEquals(2,fori.listAll());
    }

    @Test
    public void testListAllByIterator() {
        Fori fori = new Fori();
        assertEquals(2, fori.listAllByIterator());
    }

    @Test
    public void testListAllByStream() {
        Fori fori = new Fori();
        assertEquals(2, fori.listAllByStream());
    }
}