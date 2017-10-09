package com.vilen.learn.chapter4;

/**
 * Created by vilen on 2017/10/9.
 * http://ebnbin.com/2015/12/20/java-8-default-methods/
 */
public class DefaultMethod {
    public interface InterfaceA {
        public default void foo() {
            System.out.println("InterfaceA foo");
        }
    }

    public static class ClassA implements InterfaceA {

    }

    public static class Test{
        public static void main(String[] args) {
            new ClassA().foo();
        }
    }

}
