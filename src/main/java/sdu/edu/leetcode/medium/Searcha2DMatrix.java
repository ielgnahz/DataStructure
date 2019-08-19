package sdu.edu.leetcode.medium;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int n = 0;
        int m = matrix[0].length;
        while(n < matrix.length && m >= 0){
            if(matrix[n][m] > target){
                m--;
            }else if(matrix[n][m] < target){
                n++;
            }else{
                return true;
            }
        }
        return false;
    }
}
