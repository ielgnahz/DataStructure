package sdu.edu.leetcode.medium;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder stringBuilder = new StringBuilder();

        int cyclelen = 2 * numRows - 2;
        for(int i = 0;i < numRows;i++){
            for(int j = 0;j + i < s.length();j += cyclelen){
                stringBuilder.append(s.charAt(i + j));
                if(i != 0 && i != numRows - 1 && j + cyclelen - i < s.length()){
                    stringBuilder.append(s.charAt(j + cyclelen - i));
                }
            }
        }
        return stringBuilder.toString();
    }

}
