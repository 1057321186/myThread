package com.project.reflect.classloader;

public class MyClassLoader extends ClassLoader{
	//创建一个自定义类加载器
	
	//在工程外创建个类，用Javac进行编译，生成class文件，
	//用自定义classLoader进入类的目录读取class文件流，并将其解析返回一个我们想要的class对象
	
	
	private String path;	//加载路径
	private String classLoaderName; 
	
	public MyClassLoader(String path, String classLoaderName) {
		this.path=path;
		this.classLoaderName=classLoaderName;
	}
	
	//用于寻找类文件,以为二进制数据流加载进来
	@Override
	@SuppressWarnings({"deprecation"})
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte [] b = loadClassDate(name);
		//return defineClass(name, 0, b.length);
		return null;
	}
	//用于加载类文件 
	private byte[] loadClassDate(String name) {
		
		return null;
	}
	
	
	
}
