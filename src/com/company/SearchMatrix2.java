package com.company;

/**
 * Created by dai on 2017/4/6.
 */
public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while(row <= matrix.length - 1 && col >= 0){
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}
