package sdu.edu.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0;i + 2 < nums.length;i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == -nums[i]){
                    result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(nums[left] + nums[right] < -nums[i]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

}
