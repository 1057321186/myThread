package com.project.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
public class Test1 {

    // 注解可以显式赋值，如果没有默认值，则必须给注解赋值
    @MyAnnotation2(value1 = "",age = 66)
    public void test(){

    }

    @MyAnnotation3("")
    public void test2(){

    }
}

/**
 * 自定义注解
 *
 * 使用@interface自定义注解时，自动继承了 java.lang.annotation.Annotation 接口
 *
 *  分析：
 *      1、@interface用来声明一个注解：格式 @interface 注解名{定义内容}
 *      2、其中的每一个方法实际上是声明了一个配置参数
 *      3、方法的名称就是参数的名称
 *      4、返回值类型就是参数的类型（返回值只能是基本类型,Class,String,enum）
 *      5、可以通过default来声明参数的默认值
 *      6、如果只有一个参数成员，一般参数名为value
 *      7、注解元素必须要有值，我们定义注解元素时，经常使用空字符串，0做默认值
 */
@Target({ElementType.TYPE,ElementType.METHOD})// 作用域类和方法
@Retention(RetentionPolicy.RUNTIME)//  注解的生命周期：运行时
@interface MyAnnotation2{
    // 注解的参数：参数类型 + 参数名（);
    String value1();
    String value2()  default "嘿嘿";
    int age();
    String[] university() default {"正因村","团结铁三角"};
}

@Target({ElementType.TYPE,ElementType.METHOD})// 作用域类和方法
@Retention(RetentionPolicy.RUNTIME)//  注解的生命周期：运行时
@interface MyAnnotation3{
    // 注解的参数：参数类型 + 参数名（);
    String value();
}

