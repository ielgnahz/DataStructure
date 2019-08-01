package sdu.edu.leetcode.medium;

import java.util.Arrays;

public class Sum3Closest {

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0;i + 2 < nums.length;i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int tmp = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - tmp) < Math.abs(target - result)){
                    result = tmp;
                }
                if(tmp < target){
                    left++;
                }else if(tmp > target){
                    right--;
                }else{
                    return tmp;
                }
            }

        }
        return result;
    }

}
