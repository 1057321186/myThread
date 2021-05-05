package com.project.niuke;

public class Test3 {
    /**
     * 非运算符用符号“~”表示，其运算规律如下：
     *
     * 如果位为0，结果是1，如果位为1，结果是0
     * @param args
     */
    public static void main(String[] args) {
        // 公式 -n = ~n + 1 可推出 ~n = -n - 1，
        // 所以 ~10 = -11 再加5结果为-6
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);
        System.out.println(~1);
        System.out.println(~2);
        System.out.println(~3);
        System.out.println(~0);
    }
}
