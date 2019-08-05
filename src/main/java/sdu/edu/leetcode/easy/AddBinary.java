package sdu.edu.leetcode.easy;

public class AddBinary {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        String str = "";
        int c = 0;
        while(i >= 0&& j >= 0){
            int p = a.charAt(i) - '0' + b.charAt(j) - '0' + c;
            c= p / 2;
            str = p % 2 + str;
            i--;j--;
        }
        while(i >= 0){
            int p = a.charAt(i) - '0' + c;
            c = p / 2;
            str = p % 2 + str;
            i--;
        }

        while(j >= 0){
            int p = b.charAt(j) - '0' + c;
            c = p / 2;
            str = p % 2 + str;
            j--;
        }
        if(c != 0){
            str = c + str;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }

}
