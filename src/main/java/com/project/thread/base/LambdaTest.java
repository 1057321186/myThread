package com.project.thread.base;

public class LambdaTest {

    // 3、静态内部类
    static class Wh2 implements Love{
        @Override
        public void say() {
            System.out.println("Wh love you");
        }
    }

    public static void main(String[] args) {

        Love love = new Wh2();
        love.say();

        //  4、局部内部类
        class Wh3 implements Love{
            @Override
            public void say() {
                System.out.println("Wh love you");
            }
        }
        Love love2 = new Wh3();
        love2.say();

        // 5、匿名内部类，没有类的名称，必须借助接口或者父类
        Love love3 = new Love() {
            @Override
            public void say() {
                System.out.println("I LOVE YOU");

            }
        };

        //  6、用lambda简化
        Love l = ()->{
            System.out.println("I LOVE YOU");
        };
        l.say();

        // 简化花括号 ：1、方法只能是一行的代码，才能优化，否则使用代码块
        //            2、前提接口是函数式接口
        l = ()-> System.out.println("I LOVE YOU");



        MyThread myThread = ()->{
            System.out.println("aaaaaaaaa");
        };
        myThread.run();

    }
}

// 1、定义函数式接口
interface Love {
    void say();
}

// 2、实现类
class Wh implements Love{

    @Override
    public void say() {
        System.out.println("Wh love you");
    }
}
interface MyThread extends Runnable{
    @Override
    void run();
}

