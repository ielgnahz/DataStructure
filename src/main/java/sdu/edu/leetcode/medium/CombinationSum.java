package sdu.edu.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        trace(candidates, 0, target, result, new ArrayList<Integer>());

        return result;
    }

    public void trace(int[] cancidates, int i, int sum, List<List<Integer>> result, List<Integer> list){
        if(sum == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int k = i;k < cancidates.length;k++){
            if(sum - cancidates[k] >= 0){
                list.add(cancidates[k]);
                trace(cancidates, k, sum - cancidates[k], result, list);
                list.remove(list.size()-1);
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
    }

}
