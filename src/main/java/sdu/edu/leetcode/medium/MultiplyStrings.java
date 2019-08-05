package sdu.edu.leetcode.medium;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String result = "0";
        for(int i = num1.length() - 1,k = 0;i >= 0;i--,k++){
            int a = num1.charAt(i) - '0';
            int c = 0;
            String str = "";
            for(int j = num2.length() - 1;j >= 0;j--){
                int b = num2.charAt(j) - '0';
                int d = (a * b + c) % 10;
                c = (a * b +c) / 10;
                str = d + str;
            }
            if(c != 0){
                str = c + str;
            }
            for(int j = 0;j < k;j++){
                str = str + "0";
            }
            result = sum(result, str);
        }
        return result;
    }

    public String sum(String str1, String str2){
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        String result = "";
        int c = 0;
        while(i >=0 && j >=0){
            int a = str1.charAt(i) - '0';
            int b = str2.charAt(j) - '0';
            result = (a + b + c) % 10 + result;
            c = (a + b + c) /10;
            i--;
            j--;
        }
        while(i>= 0){
            int a = str1.charAt(i) - '0';
            c = (a + c) /10;
            result = (a + c) % 10 + result;
            i--;
        }
        while(j>= 0){
            int b = str2.charAt(j) - '0';
            c = (b + c) /10;
            result = (b + c) % 10 + result;
            j--;
        }
        if(c != 0){
            result = c + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }
}
