package com.project.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main extends ClassLoader{
	// 反射概念：在程序动态运行过程中，能够获取到该类对象，并且能够访问他的属性和调用方法
	/*
	 * 获取类对象有3种方式
	 * 		1. Class.forName
	 * 		2. Hero.class
	 * 		3. new Hero().getClass()
	 */

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			// 方法一：Class class=Class.forName("完整的类路径");
			Class class1 = Class.forName("com.project.reflect.Person");
			// 方法二：使用 类名.class 来实现实例化
			Class class2 = Person.class;
			// 方法三：使用 new 对象.getClass();方法实现实例化
			Class class3 = new Person().getClass();
			// 在一个JVM中，一种类，只会有一个类(Class)对象存在。所以以上三种方式取出来的类对象，都是一样的。
			if (class1.hashCode() == class2.hashCode() && class1.hashCode() == class3.hashCode()) {
				System.out.println(true);
			}
			// 方式四 : 基本内置类型的包装类都有一个Type属性
			Class class4 = Integer.TYPE;
			System.out.println(class4);

			// 获得父类类型
			Class class5 = class1.getSuperclass();
			System.out.println(class5);





			/*
			 * 
			 * 通过反射获取属性
			 * 
			 * 
			 * 
			 */// 1、先初始化一个对象,再使用反射获取对象的属性
			Person person = new Person("王春", 20);
			Person person2 = (Person)class1.newInstance();
			person2.setAge(10);
			person2.setName("李白");

			// 2、获取属性
			Field field = class1.getDeclaredField("name");// getDeclaredField()能获取所有字段，但不能获取private的值，除非加上setAccessible(true)
			// Field field2=class1.getField("age");//getField()只能获取public的属性
				
			System.out.println(field);
			Field[] fields = class1.getFields();
			System.out.println("输出所有的public属性");
			for (Field f : fields) {
				System.out.print(f);
			}
			// 3、修改属性值(如果是私有属性，则需要设置为可以访问)
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			field.set(person, "李麒麟");
			System.out.println("\n"+person.getName());

			/*
			 * 调用方法
			 * 
			*/
			// 获取这个名字叫做setName，参数类型是String的class
			Method method=class1.getMethod("setName", String.class);
			// 对person对象，调用setName这个方法
			method.invoke(person,"陈潇" );
			// 使用传统的方式，调用getName方法
			System.out.println(person.getName());

			Method method1 = class1.getMethod("say");
			method1.invoke(person);

			//获取所有方法
			Method [] methods=class1.getDeclaredMethods();
			for(Method method2:methods){
				System.out.println(method2.getName()+":"+method2.getReturnType()+":"+method2.getParameterTypes());
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
