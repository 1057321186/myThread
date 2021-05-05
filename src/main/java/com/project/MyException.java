package com.project;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 自定义异常类
 */
public class MyException extends Exception {

    public static void main(String[] args) {
        MyException exception  =  new MyException();
        System.out.println(new Date());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> exception.spend1s());
        System.out.println(new Date());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private String spend1s() {
        try {
            this.wait(1000);
            System.out.println("多线程"+new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            return "asdasd";
    }
}
