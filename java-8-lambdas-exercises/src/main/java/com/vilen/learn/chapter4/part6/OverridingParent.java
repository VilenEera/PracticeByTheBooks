package com.vilen.learn.chapter4.part6;

/**
 * Created by vilen on 2017/10/9.
 */
public class OverridingParent extends ParentImpl {
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}
