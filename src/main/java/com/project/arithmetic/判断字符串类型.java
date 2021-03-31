package com.project.arithmetic;

import java.util.Scanner;

public class 判断字符串类型 {
	public static   void main(String args[]){
		int num=0,chartra=0,blak=0,other=0;
		Scanner  s=new Scanner(System.in);
		System.out.print("请输出字符串:");
		String   result=s.nextLine();
		char x[]=result.toCharArray();
		for(int i=0;i<x.length;i++){
		   if(Character.isDigit(x[i])){
			   num++;
		   }else if(Character.isLetter(x[i])){
			   chartra++;
		   }else if(Character.isSpaceChar(x[i])){
			   blak++;
		   }
		   else{
			   other++;
		   }

		}
		System.out.println(x.length);
		System.out.println("数字的个数是"+num);
		System.out.println("字符的个数是"+chartra);
		System.out.println("空值的个数是"+blak);
		System.out.println("其他的个数是"+other);
	}
}
