package com.company;

/**
 * Created by dai on 2017/5/28.
 */
public class SetMatrixZeroes {
    //time com:O(mn),space com: O(1)
    //Runtime: 2 ms, beats 29.61 %
    public void setZeroes(int[][] matrix) {
        //用第一行和第一列c表示该行或该列是否存在0，作为后面置0的标志
        //但matrix[0][0]表示第一行，col0表示第一列，避免冲突
        //不用考虑覆盖第一行和第一列的值，因为被标记为0的，本该被设置为0
        if(matrix==null || matrix.length==0) return;

        //设置标记位
        int col0=1;
        int row=matrix.length, col=matrix[0].length;
        for(int i=0; i<row; i++){
            if(matrix[i][0]==0)
                col0=0;
            for(int j=1; j<col; j++){
                if(matrix[i][j]==0)
                    matrix[i][0]=matrix[0][j]=0;
            }
        }

        //根据标记改变其他位的值
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(matrix[0][0]==0)
            for(int j=1; j<col; j++)
                matrix[0][j]=0;
        if(col0==0)
            for(int i=0; i<row; i++)
                matrix[i][0]=0;
    }
}
