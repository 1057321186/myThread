package com.project.arithmetic;

/**
 *
 * 1、比较数组中两个相邻的元素，如果第一个比第二个大，我们就交换他们的位置
 * 2、每一次比较，都会产生出一个最大，或者最小的数字
 * 3、下一轮则可以少一次排序！
 * 4、依次循环，直到结束
 * 时间复杂度O(n2)
 */
public class 冒泡 {
	
	public static void main(String[] args) {
		// 数据源
		int arr[]={7,2,1,10,6,3,8};
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]<arr[j+1]){
					arr[j]=arr[j+1]+arr[j];
					arr[j+1]=arr[j]-arr[j+1];
					arr[j]=arr[j]-arr[j+1];
				}
			}
		}
		for(int i:arr){
			System.out.print(i+" ");
		}
	}

}
