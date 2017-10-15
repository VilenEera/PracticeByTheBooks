package com.vilen.learn.chapter7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    //使用Mockito 这样的框架有助于更容易地产生测试替身。
    private List<Integer> otherList = Arrays.asList(1, 2, 3);
    @Test
    public void mockitoLambdas() {
        //我们不想返回List 本上的长度，而是返回另一个List 的长度，
        //为了模拟List 的size 方法，我们不想只给出答案，还想做一些操作，因此传入一个Lambda表达式
        List<String> list = mock(List.class);
        when(list.size()).thenAnswer(invocationOnMock -> otherList.size());
        assertEquals(3, list.size());
    }
    //Mockito使用Answer 接口允许用户提供其他行为，换句话说，这是我们的老朋友：代码即数据。
    //之所以在这里能使用Lambda表达式，是因为Answer 本身就是一个函数接口
}