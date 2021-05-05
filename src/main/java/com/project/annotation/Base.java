package com.project.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;


/**
 * 测试元注解
 */
@MyAnnotation
public class Base {


    @MyAnnotation
    public void test(){

    }
}


// 定义一个注解
// 元注解

// 表示注解的使用范围(方法、类...ElementType)
@Target(value = {ElementType.METHOD,ElementType.TYPE})
// @Retention 表示我们的注解在什么地方还有效
// runtime > class > source
@Retention(value = RetentionPolicy.RUNTIME)
// 表示是否将我们的注解生成在JAVADoc中
@Documented

// @Inherited 子类可以继承父类中的该注解
@Inherited
@interface MyAnnotation{

}