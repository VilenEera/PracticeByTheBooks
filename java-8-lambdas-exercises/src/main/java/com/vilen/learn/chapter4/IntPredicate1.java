package com.vilen.learn.chapter4;

/**
 * Created by vilen on 2017/10/9.
 */
@FunctionalInterface
public interface IntPredicate1 {
    public boolean test(int value);
    //该注释添加给一个枚举类型、类或另一个注释，或者接口包含不止一个抽象方法，javac 就会报错。
    // 重构代码时，使用它能很容易发现问题。
    // public boolean test1(int value);
}
