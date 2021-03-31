package com.project.io;

import java.io.File;
import java.io.IOException;

public class FileClass {
	
	/*
	 * 判断C:\\Users\\Administrator\\Desktop\\QQ\\IOtest.txt文件是否存在
	 * 如果存在，则删除
	 * 不存在则创建一个新的文件
	 */
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Administrator\\Desktop\\IOtes.txt");	//创建一个file对象并指明地址
		if(file.exists()){		//判断文件是否存在
			//file.delete();
			//System.out.print("文件被删除");
			/***********获取文件的信息***********/
			String name = file.getName();		//获取文 件名字
			long length = file.length();	//获取文件长度
			boolean ifhidden=file.isHidden();	//判断是否为隐藏文件
			boolean ifDirectory = file.isDirectory();	//判断是否为一个文件夹
			System.out.println("文件名:"+name);
			System.out.println("文件长度:"+length);
			System.out.println("是否为隐藏文件"+ifhidden);
			System.out.println("是否为文件夹"+ifDirectory);
			System.out.println("文件路径"+file.getAbsolutePath());
		}else {
			try {
				file.createNewFile();//创建一个新的文件
				System.out.println("文件被已经创建");
				
				/***********获取文件的信息***********/
				String name = file.getName();		//获取文件名字
				long length = file.length();	//获取文件长度
				boolean ifhidden=file.isHidden();	//判断是否为隐藏文件
				boolean ifDirectory = file.isDirectory();	//判断是否为一个文件夹
				System.out.println("文件名:"+name);
				System.out.println("文件长度:"+length);
				System.out.println("是否为隐藏文件"+ifhidden);
				System.out.println("是否为文件夹"+ifDirectory);
				System.out.println("文件路径"+file.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
}

