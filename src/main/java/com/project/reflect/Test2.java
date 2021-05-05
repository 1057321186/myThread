package com.project.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//获取类的所有信息
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class person = Class.forName("com.project.reflect.Person");

        // 获取类名
        System.out.println(person.getSimpleName());// 类名
        System.out.println(person.getName());// 包名+类名

        // 获取类的属性
        // 只能找到public属性
        Field[] fields = person.getFields();//
        for(Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===属性=============================");
        // getDeclaredField()能获取所有字段，但不能获取private的值，除非加上setAccessible(true)
        Field[] allFields = person.getDeclaredFields();//
        for(Field field : allFields) {
            System.out.println(field);
        }

        System.out.println("=================================");

        // 获取私有属性值,并通过反射修改其值
        Person person2 = new Person("王春", 20);
        Class aClass = person2.getClass();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(person2.getName());
        name.set(person2,"王春春");
        System.out.println(person2.getName());

        System.out.println("===方法==============================");

        // 获取方法
        // 获取Public
        Method[] methods = person.getMethods();
        for (Method method : methods) {
//            System.out.println(method.getName()+":"+method.getReturnType()+":"+method.getParameterTypes());
            System.out.println(method);
        }

        System.out.println("=================================");
        // 获取所有
        Method[] declaredMethods = person.getDeclaredMethods();
        for (Method method : declaredMethods) {
//            System.out.println(method.getName()+":"+method.getReturnType()+":"+method.getParameterTypes());
//            System.out.println(method.getModifiers());
            System.out.println(method);
        }

        System.out.println("====================");

        // 获取构造方法
        Constructor[] constructors = person.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor[] constructors2 = person.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println(constructor);
        }


        // 获取指定的方法并调用
        // 获取这个名字叫做setName，参数类型是String的class
        Method eat = person.getDeclaredMethod("eat",String.class);
//        eat.invoke(person,"哈密瓜");
        eat.setAccessible(true);
        // 构造对象
        Person person3 = (Person)person.newInstance();
        // invoke:激活
        // 对象、方法的参数值
        eat.invoke(person3,"哈密瓜");


        // 构造对象
        //
        Person p = (Person) person.newInstance();//本质是调用了类的无参构造

        // 通过构造器创建对象
        Constructor declaredConstructor = person.getDeclaredConstructor(String.class, int.class);
        Person  person4 = (Person) declaredConstructor.newInstance("李麒麟", 18);
    }

}
