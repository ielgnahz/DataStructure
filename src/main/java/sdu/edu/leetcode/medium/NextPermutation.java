package sdu.edu.leetcode.medium;

public class NextPermutation {

    /*
            1 5 8 4 7 6 5 3 1
     */
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }

        for(int i = nums.length - 1; i > 0;i--){
            if(nums[i - 1] < nums[i] ){
                for(int j = nums.length - 1;j >= i;j--){
                    if(nums[j] >nums[i - 1]){
                        swap(nums, i, j);
                        reverse(nums, i, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums,int i,int j ){
        while(i < j){
            swap(nums, i++, j--);
        }
    }

}
