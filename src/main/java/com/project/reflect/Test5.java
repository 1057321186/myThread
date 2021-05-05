package com.project.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射操作注解
 */
public class Test5 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        Class c1 = Class.forName("com.project.reflect.Student");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解的value的值
        TableStudent student = (TableStudent) c1.getAnnotation(TableStudent.class);
        String value = student.value();
        System.out.println(value);

        // 获得类中属性的注解
        Field id = c1.getDeclaredField("id");
        Column annotation = id.getAnnotation(Column.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }

}

// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableStudent{
    String value();
}

// 字段的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column{
    String columnName();
    String type();
    int length();
}


@TableStudent(value = "db_student")
class Student{

    @Column(columnName = "db_id",type = "int",length = 10)
    int id;

    @Column(columnName = "db_name",type = "String",length = 10)
    String name;

    @Column(columnName = "db_age",type = "int",length = 10)
    int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Sutdent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
