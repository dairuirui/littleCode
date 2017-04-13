package com.company;

/**
 * Created by dai on 2017/4/6.
 */
public class SearchMatrix {

    //当作sorted list
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        if(matrix[0].length == 0)
            return false;
        int m=matrix.length, n=matrix[0].length;
        int l=0, r=m*n-1;
        while(l != r){
            int mid = (l+r)/2;
            if(matrix[mid/n][mid%n] == target)
                return true;
            if(matrix[mid/n][mid%n] < target)
                l = mid+1;
            else
                r=mid;
        }
        return matrix[r/n][r%n] == target;
    }

    //当作2D matrix，效率很低
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix.length == 0)
//            return false;
//        int m=matrix.length, n=matrix[0].length;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j] == target)
//                    return true;
//                if(matrix[i][j] > target)
//                    return false;
//            }
//        }
//        return false;
//    }
}
