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

    @Test
    public void testListAllByStream1() {
        Fori fori = new Fori();
        fori.listAllByStream1();
        // 不打印语句
    }

    @Test
    public void testListAllByStream2() {
        Fori fori = new Fori();
        fori.listAllByStream2();
        // 打印语句
    }
}