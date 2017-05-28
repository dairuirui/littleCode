package com.company;

/**
 * Created by dai on 2017/5/24.
 */
public class SpiralMatrixII {
    //Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    //��n*n�ľ����У�˳ʱ������n^����

    //time com:O(n^2),,space com:O(n^2)
    //Runtime: 3 ms,,beats 18.07 %
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==0) return matrix;

        int num=1;
        int rowStart=0, rowEnd=n-1;
        int colStart=0, colEnd=n-1;
        while(rowStart<=rowEnd){
            //������
            for(int j=colStart; j<=colEnd; j++){
                matrix[rowStart][j]=num;
                num++;
            }
            rowStart++;

            //���ϵ���
            for(int i=rowStart; i<=rowEnd; i++){
                matrix[i][colEnd]=num;
                num++;
            }
            colEnd--;

            //���ҵ���
            if(rowStart<=rowEnd)
                for(int j=colEnd; j>=colStart; j--){
                    matrix[rowEnd][j]=num;
                    num++;
                }
            rowEnd--;

            //���µ���
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
