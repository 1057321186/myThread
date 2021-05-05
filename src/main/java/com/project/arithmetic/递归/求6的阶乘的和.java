package com.project.arithmetic.递归;

public class 求6的阶乘的和 {
	// 递归求和
	public static void main(String[] args) {
		System.out.println(count(2));
	}

	static int count(int i) {
		if (i > 1) {
			return i + count(--i);
		}else {
			return 1;
		}
	}
}
