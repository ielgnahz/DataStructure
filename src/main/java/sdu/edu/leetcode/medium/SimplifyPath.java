package sdu.edu.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SimplifyPath {

//    public String simplifyPath(String path) {
//        Stack<String> stack = new Stack<>();
//        Set<String> set = new HashSet<>(Arrays.asList("..",".",""));
//        for(String str : path.split("/")){
//            if(str.equals("..") && !stack.isEmpty()) stack.pop();
//            else if(!set.contains(str)) stack.push(str);
//        }
//        String res = "";
//        for(String str : stack){
//            res += "/" + str ;
//        }
//        return stack.isEmpty()?"/":res;
//    }

    public String simplifyPath(String path) {

        int i = 0;
        int count = 0;
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(i < path.length() && path.charAt(i) == '/'){
            i++;
        }
        for(;i < path.length();i++){
            if(path.charAt(i) == '.'){
                count++;
            }else if(path.charAt(i) == '/'){
                if(count == 3){
                    stack.push("...");
                    count = 0;
                }if(count == 2){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    count = 0;
                }else if(count == 1){
                    count = 0;
                }else if(sb.length() != 0){
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            }else{
                while(count != 0){
                    sb.append(".");
                    count--;
                }
                sb.append(path.charAt(i));
            }
        }

        if(count == 3){
            stack.push("...");
        }if(count == 2){
            if(!stack.isEmpty()){
                stack.pop();
            }
        }else if(sb.length() != 0){
            stack.push(sb.toString());
            sb.setLength(0);
        }

        if(stack.isEmpty()){
            return "/";
        }else{
            for(int j = 0;j < stack.size();j++){
              sb.append("/").append(stack.get(j));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home/"));
    }

}
