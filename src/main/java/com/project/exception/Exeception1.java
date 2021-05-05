package com.project.exception;

/**
 *
 * Throwable：所有异常和错误的父类
 * Error、Exception 是子类
 *
 * 处理异常：
     * try：监控区域
     * catch：捕获异常
     * finally：无论是否捕获异常最终执行
     * throw：主动抛出异常
     * throws：声明异常
 */
public class Exeception1 {
    public static void main(String[] args) {
        String s ="jzVjDXqjZXelO4g9W60tAi2kqQXzH7B7A4_-sUZYma8";
        try {
            test2();
        } catch (Exception e) {
            // 捕获异常，级别需要从小到大捕获
            e.printStackTrace();
        }
        System.out.println(s.length());

    }

    void test(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            try {

            }catch (Exception e){
                System.out.println("E");
            }
            if (arr[i] % 2 != 0) {
                throw new NullPointerException();
            }else {
                System.out.println(arr[i]);
            }
        }
    }
    static void test2() throws Exception{
        System.out.println(10/0);
    }
}
