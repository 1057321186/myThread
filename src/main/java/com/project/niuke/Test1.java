package com.project.niuke;

public class Test1 {
    /**
     * 如果finally块中有return语句的话，
     * 它将覆盖掉函数中其他return语句。
     */
    public static void main(String args[]){
    int num = 10;
    System.out.println(test(num));
    }
    public static int test(int b){
        try{
             b += 10;
            return b;
         }catch(RuntimeException e){

        }catch(Exception e2){

         }finally{
          b += 10;
        return b;
        }
        }
}
