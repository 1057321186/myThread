package com.project.thread;

/**
 *  守护线程
 *
 *  线程分为 用户线程 和 守护线程
 *  虚拟机必须确保用户线程执行完毕
 *  虚拟机不用等待守护线程执行完毕
 *  如：后台记录操作日志，监控内存，垃圾回收等
 *
 */
public class DaemonDemo {
    public static void main(String[] args) {
        God god = new God();
        Me me = new Me();
        Thread thread = new Thread(god);
        thread.setDaemon(true);// 默认false表示用户线程，true为守护线程,一般都是用户线程
        thread.start();//

        new Thread(me).start();
        // 用户线程执行完毕后，虚拟机关闭时守护线程会执行一会儿就关闭
    }



}

// 玉皇大帝
class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("God Bless me");
        }
    }
}

// 我
class Me implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("我天天的要开心得很");
        }
        System.out.println("====ByeBye World====");
    }
}