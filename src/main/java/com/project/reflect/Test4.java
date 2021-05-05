package com.project.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型
 */
public class Test4 {
    public void test1(Map<String,Person> map, List<Person> personList) {
        System.out.println("test1");
    }

    public Map<String,Person> test2() {
        return null;
    }


    public static void main(String[] args) throws NoSuchMethodException {

        Method test1 = Test4.class.getMethod("test1", Map.class, List.class);

        // GenericParameterType表示一种元素类型是参数化类型或者类型变量的数组类型
        Type[] genericParameterTypes = test1.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            // ParameterizedType 表示一种参数化类型，如 Collection<String>
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        Method test2 = Test4.class.getMethod("test2", null);
        Type genericReturnType = test2.getGenericReturnType();
            if (genericReturnType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
        }



    }

}
