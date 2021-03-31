package com.project.exception;

public class Exeception1 {
    public static void main(String[] args) {
    String s ="jzVjDXqjZXelO4g9W60tAi2kqQXzH7B7A4_-sUZYma8";
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
}
