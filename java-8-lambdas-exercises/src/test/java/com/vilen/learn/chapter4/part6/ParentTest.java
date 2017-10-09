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


}