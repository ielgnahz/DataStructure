package sdu.edu.leetcode.medium;

public class SpiralMatrixII {
    int k = 1;
    public int[][] generateMatrix(int n) {
        int tR = 0;
        int tC = 0;
        int dR = n - 1;
        int dC = n-1;
        int[][] matrix = new int[n][n];
        while(tR <= dR && tC <= dC){
            print(matrix,tR++,tC++,dR--,dC--);
        }
        return matrix;
    }

    public void print(int[][]matrix, int tR,int tC,int dR,int dC){
        if(tR == dR){
            for(int i = tC;i<=dC;i++){
                matrix[tR][i] = k++;
            }
        }else if(tC == dC){
            for(int i = tR;i<=dR;i++){
                matrix[i][tC] = k++;
            }
        }else{
            int curR = tR;
            int curC = tC;
            while(curC < dC){
                matrix[tR][curC++] = k++;
            }
            while(curR < dR){
                matrix[curR++][dC] = k++;
            }
            while(curC > tC){
                matrix[dR][curC--] = k++;
            }
            while(curR > tR){
                matrix[curR--][tC] = k++;
            }
        }
    }
}
