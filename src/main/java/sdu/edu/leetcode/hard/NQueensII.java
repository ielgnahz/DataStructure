package sdu.edu.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    int ans = 0;
    public int totalNQueens(int n) {
        trace(new ArrayList<Integer>(), 0, n);
        return ans;
    }

    public void trace(List<Integer> list, int index, int n){
        if(n == index){
            ans++;
            return;
        }
        //list中索引为列，存储的是行，list.get(0) == 1为第1行的第0列为'Q'
        for(int i = 0;i < n;i++){
            if(valid(list,i)){
                list.add(i);
                trace(list, index + 1, n);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean valid(List<Integer> list, int row){
        int size = list.size();
        for(int i = 0;i < size;i++){
            if(row == list.get(i) || row + size == i +list.get(i) || row + i == list.get(i) + size){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
    }

}
