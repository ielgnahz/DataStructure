package sdu.edu.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        commons("", result, n, n);
        return result;
    }

    public void commons(String str, List<String> result, int open, int close){
        if(open > close){
            return;
        }
        if(open == 0 && close == 0){
            result.add(str);
            return;
        }
        if(open > 0){
            commons(str + "(", result, open-1, close);
        }
        if(close > 0){
            commons(str + ")", result, open, close - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

}
