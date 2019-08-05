package sdu.edu.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if(board.length == 0) return;
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board,int i,int j){
        if(i == 9){
            return true;
        }
        if(board[i][j] != '.'){
            return solve(board, j == 8?i+1:i, j == 8?0:j+1);
        }else{
            for(char c = '1';c <= '9';c++){
                if(isValidSudo(board, i, j, c)){
                    board[i][j] = c;
                    if(solve(board, j == 8?i+1:i, j == 8?0:j+1)){
                        return true;
                    }else{
                        board[i][j] = '.';
                    }

                }
            }
        }
        return false;

    }

    public boolean isValidSudo(char[][] board,int i,int j,char c){
        for(int k = 0;k < board.length;k++){
            if(board[i][k] != '.' && board[i][k] == c){
                return false;
            }
            if(board[k][j] != '.' && board[k][j] == c){
                return false;
            }
            if(board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] != '.' && board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c){
                return false;
            }
        }
        return true;
    }

}
