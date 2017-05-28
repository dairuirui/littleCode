package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dai on 2017/5/23.
 */
public class SpiralMatrix {
    //˳ʱ���ӡ����

    //����һ��
    //idea������ѭ����ע��߽�����
    //time com: O(mn),,space com:O(mn)
    //Runtime: 3 ms,,beats 28.74 %
    public List<Integer> list = new ArrayList<>();
    public List<Integer> spiralOrder1(int[][] matrix) {
        if(matrix == null) return null;
        if(matrix.length == 0) return list;
        int row=matrix.length, col=matrix[0].length;
        int start=0;
        while((start*2 < row) && (start*2 < col)){//ÿ��ѭ������һȦ
            printInCircle(matrix, col-1-start, row-1-start, start, list);
            ++start;
        }
        return list;
    }
    public void printInCircle(int[][] matrix, int endX, int endY, int start, List<Integer> list){
        //�����Ҵ�ӡһ�У�����һ��
        for(int i=start; i<=endX; i++)
            list.add(matrix[start][i]);
        //���ϵ��´�ӡһ�У���������
        if(endY>start){
            for(int j=start+1; j<=endY; j++)
                list.add(matrix[j][endX]);
        }
        //���ҵ�����ӡһ�У�������������
        if(endX>start && endY>start){
            for(int i=endX-1; i>=start; i--)
                list.add(matrix[endY][i]);
        }
        //���µ��ϴ�ӡһ�У�������������
        if(endX>start && endY>start+1){
            for(int j=endY-1; j>=start+1; j--)
                list.add(matrix[j][start]);
        }
    }

    //��������
    //idea:ֱ���ж��Ƿ���δ��ӡԪ��,ע��߽�����
    //time com: O(mn),,space com:O(mn)
    //Runtime: 3 ms,,beats 28.74 %
    public List<Integer> spiralOrder2(int[][] matrix) {
        if(matrix == null) return null;
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int rowBegin=0, rowEnd=matrix.length-1;
        int colBegin=0, colEnd=matrix[0].length-1;
        while(rowBegin<=rowEnd && colBegin<=colEnd){//ÿ��ѭ������һȦ
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
