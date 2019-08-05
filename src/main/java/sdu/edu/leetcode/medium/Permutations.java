package sdu.edu.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return Collections.emptyList();
//        trace(nums, new ArrayList<Integer>());
        trace2(nums,0);
        return result;
    }

    public void trace2(int[] nums,int i){
        if(i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
        }
        for(int j = i;j < nums.length;j++){
            swap(nums, j, i);
            trace2(nums, i + 1);
            swap(nums, i, j);
        }
    }

    public void swap(int[] num, int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public void trace(int[] nums,List<Integer> list){
        if(nums.length == list.size()) result.add(new ArrayList<Integer>(list));
        for(int i = 0;i < nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            trace(nums, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }

}
