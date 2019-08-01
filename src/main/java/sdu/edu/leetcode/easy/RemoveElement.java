package sdu.edu.leetcode.easy;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int tail = 0;
        while(i < nums.length){
            if(nums[i] == val){
                i++;
            }else{
                nums[tail++] = nums[i];
                i++;
            }
        }
        return tail;
    }

}
