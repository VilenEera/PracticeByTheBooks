package com.vilen.learn.chapter4.part6;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vilen on 2017/10/9.
 */
public class ParentTest {

    @Test
    public void parentDefaultUsed() throws Exception {
        Parent parent = new ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!",parent.getLastMessage());
    }

    @Test
    public void childOverrideDefault() {
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!", child.getLastMessage());
    }

    @Test
    public void concreteBeatsDefault() {
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }

    // 最后，调用的是OverridingParent 中的welcome 方法，而不是Child 接口中定义的默认方法
    // 原因在于，与接口中定义的默认方法相比，类中重写的方法更具体

    // 简言之，类中重写的方法胜出 。这样的设计主要是由增加默认方法的目的决定的，增加默认方法主要是为了在接口上向后兼容。
    // 让类中重写方法的优先级高于默认方法能简化很多继承问题
    @Test
    public void concreteBeatsCloserDefault() {
        Child child = new OverridingChild();
        child.welcome();
        assertEquals("Class Parent: Hi!", child.getLastMessage());
    }

}