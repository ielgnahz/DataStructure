package sdu.edu.leetcode.medium;

import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if(candidates.length == 0) return Collections.emptyList();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        sum(result, 0, target, new ArrayList<Integer>(), candidates);
        return result;
    }

    public void sum(List<List<Integer>> result, int i,int sum, List<Integer> list,int[] candidates){
        if(sum == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int k = i ;k < candidates.length;k++){
            if(k > i && candidates[k] == candidates[k-1]){
                continue;
            }
            if(sum - candidates[k] >= 0){
                list.add(candidates[k]);
                sum(result, k + 1, sum - candidates[k], list, candidates);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

}
