package com.vilen.learn.chapter4.part7;

/**
 * Created by vilen on 2017/10/9.
 */
public class MusicalCarriage implements Carriage,Jukebox{
    @Override
    public String rock() {
        // 使用了增强的super 语法，用来指明使用接口Carriage 中定义的默认方法。
        // 此前，使用super 关键字是指向父类，现在使用类似InterfaceName.super 这样的语法指的是继承自父接口的方法。
        return Carriage.super.rock();
    }
}
