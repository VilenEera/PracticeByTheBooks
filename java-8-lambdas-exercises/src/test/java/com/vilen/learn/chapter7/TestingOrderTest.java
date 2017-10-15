package com.vilen.learn.chapter7;

import com.vilen.learn.chapter1.Album;
import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by vilen on 2017/10/15.
 */
public class TestingOrderTest {
    ////使用Lambda表达式编写测试替身，传给countFeature 方法
    @Test
    public void canCountFeatures() {
        OrderDomain order = new OrderDomain(asList(
                newAlbum("Exile on Main St."),
                newAlbum("Beggars Banquet"),
                newAlbum("Aftermath"),
                newAlbum("Let it Bleed")
        ));
        //对于countFeature 方法的期望行为是为传入的专辑返回某个数值。这里传入4张专辑，测试存根中为每张专辑返回2，
        //然后断言该方法返回8，即2×4。
        assertEquals(8, order.countFeature(value -> 2));
    }

    private Album newAlbum(String name) {
        return new Album(name, Collections.emptyList(), Collections.emptyList());
    }
}
