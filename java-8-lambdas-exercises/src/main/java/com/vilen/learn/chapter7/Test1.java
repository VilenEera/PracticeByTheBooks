package com.vilen.learn.chapter7;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.SampleData;

/**
 * Created by vilen on 2017/10/13.
 */
public class Test1 {

    public static void main(String[] args) {
        ThreadLocal<Album> thisAlbum = new ThreadLocal<Album>(){
            @Override
            protected Album initialValue() {
                return SampleData.aLoveSupreme;
            }
        };

        //第二个例子优于前一个有以下几个原因。首先，任何已有的Supplier<Album> 实例不需要重新封装，就可以在此使用，这鼓励了重用和组合。
        //JVM会少加载一个类
        ThreadLocal<Album> thatAlbum = ThreadLocal.withInitial(() -> SampleData.aLoveSupreme);
    }
}
