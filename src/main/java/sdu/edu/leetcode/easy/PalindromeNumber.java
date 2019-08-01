package sdu.edu.leetcode.easy;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int tmp = 0;
        int res = x;
        while(res >= 10){
            tmp = tmp * 10 + res % 10;
            res = res /10;
        }
        if(res != 0){
            tmp = tmp * 10 + res;
        }
        return tmp == x;
    }

}
