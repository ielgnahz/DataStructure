package sdu.edu.leetcode.easy;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int next = 0;
        for(int i = 0;i < nums.length;i++){
            if(next >= i){
                next = Math.max(nums[i] + i, next);
            }else{
                return false;
            }
        }
        return true;
    }

}
