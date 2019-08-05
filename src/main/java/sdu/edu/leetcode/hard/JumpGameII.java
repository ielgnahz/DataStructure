package sdu.edu.leetcode.hard;

public class JumpGameII {

    public int jump(int[] nums) {
        int end = 0;
        int step = 0;
        int maxPoint = 0;
        for(int i = 0;i < nums.length;i++){
            maxPoint = Math.max(maxPoint, i + nums[i]);
            if(i == end){
                end = maxPoint;
                step++;
            }
        }
        return step;
    }

}
