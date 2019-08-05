package sdu.edu.leetcode.medium;

import java.util.*;

public class PermutationsII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return Collections.emptyList();
        trace(nums, 0);
        return result;
    }

    public void trace(int[] nums,int i){
        if(i == nums.length){
            List<Integer> list= new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
        }
        Set<Integer> set = new HashSet<>();
        for(int j = i;j < nums.length;j++){
            if(!set.add(nums[j])) continue;
            swap(nums, i, j);
            trace(nums, i + 1);
            swap(nums, i, j);
        }
    }

    public void swap(int[] num,int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1,1,2}));
    }

}
