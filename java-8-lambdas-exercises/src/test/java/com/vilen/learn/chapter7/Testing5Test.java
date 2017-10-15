package com.vilen.learn.chapter7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/15.
 */
public class Testing5Test {

    @Test
    public void testAllToUpperCase() throws Exception {
        List<String> input = asList("a", "b", "hello");
        List<String> result = Testing5.allToUpperCase(input);
        assertEquals(asList("A", "B", "HELLO"), result);
    }
//测试字符串包含两个字符的情况，第一个字母被转换为大写
    @Test
    public void twoLetterStringConvertedToUppercaseLambdas() {
        List<String> input = Arrays.asList("ab");
        List<String> result = Testing5.elementFirstToUpperCaseLamdas(input);
        assertEquals(asList("Ab"), result);
    }

    // 单独测试
    @Test
    public void twoLetterStringConvertedToUppercase() {
        String input = "ab";
        String result = Testing5.firstToUppercase(input);
        assertEquals("Ab", result);
    }



}