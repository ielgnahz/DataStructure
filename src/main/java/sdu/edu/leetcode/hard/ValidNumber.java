package sdu.edu.leetcode.hard;

public class ValidNumber {
    public boolean isNumber(String s) {
        int i = 0;
        int len = s.length();
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            i++;
        }
        int before = i;
        while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            i++;
        }
        boolean flag = i > before;
        if(i < len && s.charAt(i) == '.'){
            i++;
            before = i;
            while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                i++;
            }
            flag = flag || (i > before);
        }
        if(i < len && s.charAt(i) == 'e'){
            i++;
            if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')){
                i++;
            }
            before = i;
            while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                i++;
            }
            flag = flag && (i > before);
        }
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        return i == len && flag;
    }

    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("005047e+6"));
    }
}
