package com.project.reflect.classloader;

public class Base {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器-》》扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类加载器-》》根加载器(c/c++)
        ClassLoader parent2 = parent.getParent();
        System.out.println(parent2);

        // 测试JDK内置类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        // 测试当前类是哪个加载器加载的
        classLoader = Class.forName("com.project.reflect.classloader.Base").getClassLoader();
        System.out.println(classLoader);

        // 双亲委派机制
        /**
         * 亲委派机制：
         * 1、自底向上检查类是否已经被装载
         * 2、自顶向下尝试加载类
         */

        // 如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        /**
         D:\java\jdk1.8.0_161\jre\lib\charsets.jar;
         D:\java\jdk1.8.0_161\jre\lib\deploy.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\access-bridge-64.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\cldrdata.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\dnsns.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\jaccess.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\jfxrt.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\localedata.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\nashorn.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\sunec.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\sunjce_provider.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\sunmscapi.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\sunpkcs11.jar;
         D:\java\jdk1.8.0_161\jre\lib\ext\zipfs.jar;
         D:\java\jdk1.8.0_161\jre\lib\javaws.jar;
         D:\java\jdk1.8.0_161\jre\lib\jce.jar;
         D:\java\jdk1.8.0_161\jre\lib\jfr.jar;
         D:\java\jdk1.8.0_161\jre\lib\jfxswt.jar;
         D:\java\jdk1.8.0_161\jre\lib\jsse.jar;
         D:\java\jdk1.8.0_161\jre\lib\management-agent.jar;
         D:\java\jdk1.8.0_161\jre\lib\plugin.jar;
         D:\java\jdk1.8.0_161\jre\lib\resources.jar;
         D:\java\jdk1.8.0_161\jre\lib\rt.jar;
         F:\javaworkspace2\myPractice\target\classes;
         D:\maven\repository\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;
         D:\maven\repository\xml-apis\xml-apis\1.0.b2\xml-apis-1.0.b2.jar;
         D:\maven\repository\org\projectlombok\lombok\1.18.12\lombok-1.18.12.jar;
         D:\maven\repository\com\alibaba\fastjson\1.2.70\fastjson-1.2.70.jar;
         D:\maven\repository\com\google\guava\guava\23.0\guava-23.0.jar;
         D:\maven\repository\com\google\code\findbugs\jsr305\1.3.9\jsr305-1.3.9.jar;
         D:\maven\repository\com\google\errorprone\error_prone_annotations\2.0.18\error_prone_annotations-2.0.18.jar;
         D:\maven\repository\com\google\j2objc\j2objc-annotations\1.1\j2objc-annotations-1.1.jar;
         D:\maven\repository\org\codehaus\mojo\animal-sniffer-annotations\1.14\animal-sniffer-annotations-1.14.jar;
         D:\maven\repository\org\apache\commons\commons-lang3\3.3.2\commons-lang3-3.3.2.jar;
         D:\maven\repository\commons-codec\commons-codec\1.15\commons-codec-1.15.jar;
         D:\maven\repository\org\bouncycastle\bcprov-jdk15on\1.62\bcprov-jdk15on-1.62.jar;
         D:\maven\repository\com\belerweb\pinyin4j\2.5.0\pinyin4j-2.5.0.jar;
         D:\ideaIU-2018.3.4\IntelliJ IDEA 2020.1\lib\idea_rt.jar

         */
    }
}
