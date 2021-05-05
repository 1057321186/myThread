package com.project.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 提高响应速度（减少了创建线程的时间）
 * 降低资源消耗
 * 便于管理
 *
 * ExecutorService: 真正的线程池接口，常见子类，ThreadPoolExecutors
 *
 *
 *
 *  FixedThreadPool：线程数固定的线程池；
 *  CachedThreadPool：线程数根据任务动态调整的线程池；
 *  SingleThreadExecutor：仅单线程执行的线程池
 *  scheduledThreadPool：能实现定时、周期性任务的线程池
 *
 */
public class Base {

    public static void main(String[] args) {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();

    }


}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }


}
