package sdu.edu.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            switch (s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    i++;
                    break;
                case ')':
                case '}':
                case ']':
                    if(!stack.isEmpty() && stack.pop() == map(s.charAt(i))){
                        i++;
                    }else{
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public char map(Character c){
        switch (c){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }

}
