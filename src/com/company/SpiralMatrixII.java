package com.company;

/**
 * Created by dai on 2017/5/24.
 */
public class SpiralMatrixII {
    //Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    //在n*n的矩阵中，顺时针填入n^个数

    //time com:O(n^2),,space com:O(n^2)
    //Runtime: 3 ms,,beats 18.07 %
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==0) return matrix;

        int num=1;
        int rowStart=0, rowEnd=n-1;
        int colStart=0, colEnd=n-1;
        while(rowStart<=rowEnd){
            //从左到右
            for(int j=colStart; j<=colEnd; j++){
                matrix[rowStart][j]=num;
                num++;
            }
            rowStart++;

            //从上到下
            for(int i=rowStart; i<=rowEnd; i++){
                matrix[i][colEnd]=num;
                num++;
            }
            colEnd--;

            //从右到左
            if(rowStart<=rowEnd)
                for(int j=colEnd; j>=colStart; j--){
                    matrix[rowEnd][j]=num;
                    num++;
                }
            rowEnd--;

            //从下到上
            if(colStart<=colEnd)
                for(int i=rowEnd; i>=rowStart; i--){
                    matrix[i][colStart]=num;
                    num++;
                }
            colStart++;
        }
        return matrix;
    }
}
