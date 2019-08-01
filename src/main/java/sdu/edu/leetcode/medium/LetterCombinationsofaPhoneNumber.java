package sdu.edu.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) return Collections.emptyList();
        String[] strs = new String[]{"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> result = new ArrayList<>();

        trace(0,strs, digits, new StringBuilder(), result);

        return result;
    }

    public void trace(int index, String[] strs, String digits, StringBuilder stringBuilder, List<String> result){
        if(index == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }

        String str = strs[digits.charAt(index) - '0'];
        for(int i = 0;i < str.length();i++){
            stringBuilder.append(str.charAt(i));
            trace(index + 1, strs, digits, stringBuilder, result);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));
    }

}
