package com.project.base;

/**
 * 可变参数
 * JDK 1.5开始，Java支持传递同类型的可变参数给一个方法
 * 在方法声明中，在指定参数类型后加一个省略号(...)
 * 注：一个方法中，只能加一个可变参数，而且必须是方法的最后一个参数
 */
public class Main {
    public static void main(String[] args) {
        say("你","是","屎粑粑");
        say("嗯",new String[]{"你","不","是"});
    }

    static void say (String a,String... word){
        System.out.println(a);
        if (word.length == 0) {
            return;
        }
        for (int i=0;i<word.length;i++) {
            System.out.println(word[i]);
        }
    }
}
