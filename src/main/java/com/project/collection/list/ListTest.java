package com.project.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
		public static void main(String[] args) {
			
/**	
 * 			ArrayList
 * 
 * 
 * */			
			ArrayList list = new ArrayList();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(3, 10);
			//遍历list
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i));
			}
			Object object;
			//判断list中是否存在某个对象
			System.out.println(list.contains(2));
			//获取元素下标
			System.out.println(list.indexOf(2));
			//通过元素下标获取元素
			System.out.println(list.get(list.indexOf(2)));
			
			
/**
 * 			LinkedList
 * **/			
			LinkedList linkedList=new LinkedList();
			linkedList.add("a");
			linkedList.add("b");
			linkedList.add("c");
			//首部添加
			linkedList.addFirst("-a");
			//尾部添加
			linkedList.addLast("d");
			//首部删除
			linkedList.removeFirst();
			//尾部删除
			linkedList.removeLast();
			//首部尾部查找
			System.out.println("首部元素查找"+linkedList.getFirst());
			System.out.println("尾部元素查找"+linkedList.getLast());
			for(int i=0;i<linkedList.size();i++){
				System.out.println(linkedList.get(i));
			}
		
			
			/*
			 * 1)系统中并不会为ArrayList<String>生成新的class文件，不会当做新的类进行处理。
			 * 不管泛型参数的类型是什么，运行时都是对应的同一个class对象。
			 * */			
			List<String> strList= new ArrayList<>();
			List<Integer> intList = new ArrayList<>();
			System.out.println(strList.getClass() == intList.getClass());
			
			/*
			 * 2)不管泛型参数是什么类型，JVM都是当做同一个类进行处理，在内存中只占用一块内存空间，因此静态方法，代码块，静态变量不能使用泛型形参。
			 * */
//			public class Test<T>{
//				   static T  info;
//				   public static void bar(T t){}
//				}
			/*
			 *3)系统中并不会真正生成泛型类，所以instanceof运算符后不能使用泛型类。 
			 * */
//			java.util.Collection<String> cs = new java.util.ArrayList<>();
//			if(cs instanceof java.util.ArrayList<String>){}
			
			/**
			 *  List 中正常删除元素的正确方法 <<<<<<<<<<<<<<<<<<<<<
			 * */
			
//			 /**
//			         * 正常删除，每次调用size方法，损耗性能，不推荐
//			         */
//			        for (int i = 0; i < list.size(); i++) {
//			            String str = list.get(i);
//			            if (str.contains("b")) {
//			                list.remove(i);
//			            }
//			        }
//
//			        /**
//			         * 正常删除，推荐使用
//			         */
//			        for (Iterator<String> ite = list.iterator(); ite.hasNext();) {
//			            String str = ite.next();
//			            if (str.contains("b")) {
//			                ite.remove();
//			            }
//			        }

			
		}
		
}
