package sdu.edu.leetcode.medium;

public class StringtoIntegerAtoi {

    public int myAtoi(String str) {
        str = str.trim();
        if(str.isEmpty()) return 0;
        int i = 0;
        boolean flag = true;
        if(str.charAt(i) == '-'){
            flag = false;
            i++;
        }else if(str.charAt(i) == '+'){
            i++;
        }
        int res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && str.charAt(i) >= '8')){
                return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + '0' - str.charAt(i);
            i++;
        }
        return flag?-res:res;
    }

    public static void main(String[] args) {
        System.out.println(new StringtoIntegerAtoi().myAtoi("-91283472332"));
    }

}
