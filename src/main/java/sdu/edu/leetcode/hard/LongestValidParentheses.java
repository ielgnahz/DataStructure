package sdu.edu.leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        char[] chrs = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        for(int i = 0;i < chrs.length;i++){
            if(chrs[i] == '('){
                left++;
            }else{
                right++;
            }
            if(right > left){
                left = 0;
                right = 0;
            }
            if(left == right){
                max = Math.max(left, max);
            }
        }
        left = 0;
        right = 0;

        for(int i = chrs.length - 1;i >= 0;i--){
            if(chrs[i] == '('){
                left++;
            }else{
                right++;
            }
            if(right < left){
                left = 0;
                right = 0;
            }
            if(left == right){
                max = Math.max(left, max);
            }
        }
        return max * 2;
    }

    public int longestValidParentheses2(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        char[] chrs = s.toCharArray();
        for(int i = 0;i < chrs.length;i++){
            if(chrs[i] == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push(i);
                    }else{
                        ans = Math.max(ans, i - stack.peek());
                    }
                }
            }
        }
        return ans;
    }

}
