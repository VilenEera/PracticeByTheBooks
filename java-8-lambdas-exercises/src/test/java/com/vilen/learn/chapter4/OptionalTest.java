package com.vilen.learn.chapter4;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vilen on 2017/10/9.
 */
public class OptionalTest {
    // 试图避免空值相关的缺陷，如未捕获的异常时
    // 可以考虑一下是否可使用Optional 对象
    @Test
    public void testOptional() throws Exception {
        Optional<String> a = Optional.of("a");
        assertEquals("a", a.get());
        assertTrue(a.isPresent());
    }

    @Test
    public void testOptional1() throws Exception {
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);
        assertFalse(emptyOptional.isPresent());

        assertEquals("b", emptyOptional.orElse("b"));
        assertEquals("c",emptyOptional.orElseGet(() -> "c"));
    }
}

