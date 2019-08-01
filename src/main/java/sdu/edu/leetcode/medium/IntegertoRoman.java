package sdu.edu.leetcode.medium;

public class IntegertoRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0;i < 13;i++){
            while(num >= value[i]){
                sb.append(roman[i]);
                num -= value[i];
            }
        }
        return sb.toString();
    }

}
