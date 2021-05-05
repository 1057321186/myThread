package com.project.annotation;

import java.util.Date;

/**
 * 内置注解
 */
public class Test0 extends Object{

    //@Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // @Deprecated 此注释可以用于修辞方法、属性、类 表示不鼓励程序员使用改元素，通常是因为它很危险，或者有更好的替代
    @Deprecated
    public static void test(){
        System.out.println("deprecated");
    }

    @SuppressWarnings("all")
    public void test2(){
        Date date = new Date();
    }

    public static void main(String[] args) {
        test();
    }

}
