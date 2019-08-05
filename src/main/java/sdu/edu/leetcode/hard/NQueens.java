package sdu.edu.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                board[i][j] = '.';
            }
        }
        trace(board,0);
        return result;
    }

    public void trace(char[][] board,int colIndex){
        if(colIndex == board.length) constructor(board);
        /*
        从左往右一列一列的判断是否有可以添加的位置
         */
        for(int i = 0;i< board.length;i++){
            if(valid(board,i,colIndex)){
                board[i][colIndex] = 'Q';
                trace(board, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }

    public boolean valid(char[][] board,int x,int y){
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < y;j++){
                /*

                   (x,y)


                   (x,y)    (i,j)


                   (x,y)
                   return false的(x,y)位置为水平，135度和225度
                 */
                if(board[i][j] == 'Q' && (x == i || x + y == i + j || x + j == y + i)){
                    return false;
                }
            }
        }
        return true;
    }

    public void constructor(char[][] board){
        List<String> list=  new ArrayList<>();
        for(int i = 0;i < board.length;i++){
            list.add(String.valueOf(board[i]));
        }
        result.add(list);
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }


}
