package sdu.edu.leetcode.medium;

import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;

        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        Arrays.fill(row, 1);
        Arrays.fill(col, 1);

        for(int i = 0;i < row.length;i++){
            for(int j = 0;j < col.length;j++){
                if(matrix[i][j] == 0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        for(int i = 0;i < row.length;i++){
            if(row[i] == 0){
                setZeroByRow(matrix, i);
            }
        }
        for(int j = 0;j < col.length;j++){
            if(col[j] == 0){
                setZeroByCol(matrix, j);
            }
        }
    }

    public void setZeroByRow(int[][] matrix, int i){
        for(int j = 0;j < matrix[0].length;j++){
            matrix[i][j] = 0;
        }
    }

    public void setZeroByCol(int[][] matrix, int j){
        for(int i = 0;i < matrix.length;i++){
            matrix[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        new SetMatrixZeroes().setZeroes(new int[][]{{0,1}});
    }

}
