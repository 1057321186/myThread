package com.project.reflect;


import java.lang.annotation.ElementType;

/**
 *  所有拥有Class对象的类型
 */
public class Test1 {
    public static void main(String[] args) {
        Class c1 = Object.class; // 类
        Class c2 = Runnable.class;//  接口
        Class c3 = String[].class;// 一维数组
        Class c4 = int[][].class;// 二维数组
        Class c5 = Override.class;// 注解
        Class c6 = ElementType.class;// 枚举
        Class c7 = Integer.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        // 只要元素类型与维度一样，就是同一个class
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
    }

}
