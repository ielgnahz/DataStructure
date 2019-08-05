package sdu.edu.leetcode.hard;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 0;

        for(int i = 0;i < nums.length;i++){
            while(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != i + 1){
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
