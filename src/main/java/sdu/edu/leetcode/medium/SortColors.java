package sdu.edu.leetcode.medium;

public class SortColors {

    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        int tail = -1;
        while(left <= right){
            if(nums[left] == 0){
                swap(nums, ++tail, left);
                left++;
            }else if(nums[left] == 2){
                swap(nums, left, right--);
            }else{
                left++;
            }
        }


    }

    public void swap(int[] num, int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2,0,2,1,1,0});
    }

}
