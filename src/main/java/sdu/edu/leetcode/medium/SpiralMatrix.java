package sdu.edu.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {

    List<Integer> result = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return Collections.emptyList();
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR <= dR && tC <= dC){
            getLen(matrix,tR++,tC++,dR--,dC--);
        }
        return result;
    }

    public void getLen(int[][] matrix,int tR,int tC,int dR,int dC){
        if(tR == dR){
            for(int i = tC;i <= dC;i++){
                result.add(matrix[tR][i]);
            }
        }else if(tC == dC){
            for(int i = tR;i<=dR;i++){
                result.add(matrix[i][tC]);
            }
        }else{
            int curC = tC;
            int curR = tR;

            while(curC < dC){
                result.add(matrix[tR][curC++]);
            }
            while(curR < dR){
                result.add(matrix[curR++][dC]);
            }

            while(curC > tC){
                result.add(matrix[dR][curC--]);
            }
            while(curR > tR){
                result.add(matrix[curR--][tC]);
            }
        }
    }

}
