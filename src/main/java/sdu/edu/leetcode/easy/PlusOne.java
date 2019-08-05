package sdu.edu.leetcode.easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int c = 0;
        digits[digits.length - 1] += 1;
        for(int i = digits.length - 1;i >=1;i--){
            c = digits[i] / 10;
            if(c == 0 ){
                return digits;
            }else{
                digits[i] %= 10;
                digits[i-1] += c;
            }
        }
        c = digits[0]/ 10;
        if(c == 0){
            return digits;
        }else{
            digits[0] %= 10;
            int[] nums = new int[digits.length + 1];
            for(int i = 1;i < nums.length;i++){
                nums[i] = digits[i-1];
            }
            nums[0] = c;
            return nums;
        }
    }
}
