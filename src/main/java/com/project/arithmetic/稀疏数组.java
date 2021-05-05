package com.project.arithmetic;

public class 稀疏数组 {
    public static void main(String[] args) {
        /**
         * 初始化二维数组
         * <p>
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 1 0 0 0 0 0 0 0 0
         *     0 0 0 0 2 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         * </p>
         */
        //初始化原数组
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][4] = 2;
        for(int[] row : array){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
        }

        System.out.println("---------> 二维数组转稀疏数组");

        /**
         * 稀疏数组
         * <p>
         *     11 11 2
         *     1  2  1
         *     2  4  2
         * </p>
         */
        //得到非0数据数
        int sum = 0;
        for (int i = 0;i<11;i++){
            for(int j = 0;j<11;j++){
                if(array[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //将非0的数放入稀疏数组
        //count：标识第几个非0数
        int count = 0;
        for (int i = 0;i<11;i++){
            for(int j = 0;j<11;j++){
                if(array[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        //遍历稀疏数组
        for(int i = 0;i<sparseArray.length;i++){
            System.out.printf("%d%d%d\t",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        System.out.println("----------->稀疏数组转回原始数组");

        /**
         * 恢复的二维数组
         * <p>
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 1 0 0 0 0 0 0 0 0
         *     0 0 0 0 2 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         *     0 0 0 0 0 0 0 0 0 0 0
         * </p>
         */

        int[][] oldArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        //将原来非0的数填充回去
        for(int i = 1;i<=count;i++){
            oldArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //遍历刚转回的原始数组
        for(int[] row : oldArray){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
        }
    }
}
