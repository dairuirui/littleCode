package com.company;

/**
 * Created by dai on 2017/5/28.
 */
public class SetMatrixZeroes {
    //time com:O(mn),space com: O(1)
    //Runtime: 2 ms, beats 29.61 %
    public void setZeroes(int[][] matrix) {
        //�õ�һ�к͵�һ��c��ʾ���л�����Ƿ����0����Ϊ������0�ı�־
        //��matrix[0][0]��ʾ��һ�У�col0��ʾ��һ�У������ͻ
        //���ÿ��Ǹ��ǵ�һ�к͵�һ�е�ֵ����Ϊ�����Ϊ0�ģ����ñ�����Ϊ0
        if(matrix==null || matrix.length==0) return;

        //���ñ��λ
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

        //���ݱ�Ǹı�����λ��ֵ
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
