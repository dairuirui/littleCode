package com.company;

/**
 * Created by dai on 2017/4/28.
 */
public class RotateImage {
    public static void main(String[] args){
        int[][] matrix={{1,2},{4,5}};
        rotate2(matrix);
        int row=matrix.length, col=matrix[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //利用数组temp
    //time com:O(n2),space com:O(n2)
    //runtime:4ms
    public static void rotate1(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return ;
        int n=matrix.length;
        int[][] temp=new int[n][n];
        int row=n, col=n;
        for(int i=0; i<n; i++){
            row=0;
            for(int j=0; j<n; j++){
                temp[row][col-1]=matrix[i][j];
                row++;
            }
            col--;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                matrix[i][j]=temp[i][j];
        }
        return;
    }

    //先对角线为轴旋转，然后列中线未轴旋转
    /*例：
    1，2，3      1,4,7     7,4,1
    4，5，6 -->  2,5,8 --> 8,5,2
    7，8，9      3,6,9     9,6,3
    * */
    //time com: O(n2),,space com: O(1)
    //runtime: 2ms, beats 75.96 %
    public static void rotate2(int[][] matrix){
        if(matrix==null || matrix.length==0)
            return ;
        int n=matrix.length;
        int temp;
        //沿对角线翻转
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //沿列中线旋转
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
        return ;
    }
}
