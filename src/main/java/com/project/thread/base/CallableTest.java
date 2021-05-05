package com.project.thread.base;

import java.util.concurrent.*;

/**
 *
 *  1、创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
 * 	2、创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
 * 	3、使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
 * 	4、调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
 *
 *  优点：可以获取返回值
 *      可以抛出异常
 */
public class CallableTest implements Callable {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<100;i++)  {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }

    public static void main(String[] args) {
        // 创建实例
        CallableTest callableTest=new CallableTest();
        // 创建执行服务
        ExecutorService  exe = Executors.newCachedThreadPool();
        // 提交执行
        Future submit = exe.submit(callableTest);
        try {
            // 获取结果
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭服务
        exe.shutdown();

//        FutureTask<Integer> futureTask = new FutureTask<>(callableTest);
//        for(int i = 0;i < 100;i++)  {
//            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
//            if(i==20)  {
//                new Thread(futureTask,"有返回值的线程").start();
//            }
//        }
//        try  {
//            System.out.println("子线程的返回值："+futureTask.get());
//        } catch (InterruptedException e)  {
//            e.printStackTrace();
//        } catch (ExecutionException e)  {
//            e.printStackTrace();
//        }

    }



}
