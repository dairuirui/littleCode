package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dai on 2017/5/23.
 */
public class SpiralMatrix {
    //顺时针打印矩阵

    //方法一：
    //idea：多重循环，注意边界条件
    //time com: O(mn),,space com:O(mn)
    //Runtime: 3 ms,,beats 28.74 %
    public List<Integer> list = new ArrayList<>();
    public List<Integer> spiralOrder1(int[][] matrix) {
        if(matrix == null) return null;
        if(matrix.length == 0) return list;
        int row=matrix.length, col=matrix[0].length;
        int start=0;
        while((start*2 < row) && (start*2 < col)){//每次循环代表一圈
            printInCircle(matrix, col-1-start, row-1-start, start, list);
            ++start;
        }
        return list;
    }
    public void printInCircle(int[][] matrix, int endX, int endY, int start, List<Integer> list){
        //从左到右打印一行，至少一行
        for(int i=start; i<=endX; i++)
            list.add(matrix[start][i]);
        //从上到下打印一列，至少两行
        if(endY>start){
            for(int j=start+1; j<=endY; j++)
                list.add(matrix[j][endX]);
        }
        //从右到做打印一行，至少两行两列
        if(endX>start && endY>start){
            for(int i=endX-1; i>=start; i--)
                list.add(matrix[endY][i]);
        }
        //从下到上打印一列，至少三行两列
        if(endX>start && endY>start+1){
            for(int j=endY-1; j>=start+1; j--)
                list.add(matrix[j][start]);
        }
    }

    //方法二：
    //idea:直接判断是否还有未打印元素,注意边界条件
    //time com: O(mn),,space com:O(mn)
    //Runtime: 3 ms,,beats 28.74 %
    public List<Integer> spiralOrder2(int[][] matrix) {
        if(matrix == null) return null;
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int rowBegin=0, rowEnd=matrix.length-1;
        int colBegin=0, colEnd=matrix[0].length-1;
        while(rowBegin<=rowEnd && colBegin<=colEnd){//每次循环代表一圈
            for(int j=colBegin; j<=colEnd; j++)
                list.add(matrix[rowBegin][j]);
            rowBegin++;

            for(int i=rowBegin; i<=rowEnd; i++)
                list.add(matrix[i][colEnd]);
            colEnd--;

            if(rowBegin<=rowEnd)
                for(int j=colEnd; j>=colBegin; j--)
                    list.add(matrix[rowEnd][j]);
            rowEnd--;

            if(colBegin<=colEnd)
                for(int i=rowEnd; i>=rowBegin; i--)
                    list.add(matrix[i][colBegin]);
            colBegin++;
        }
        return list;
    }
}
