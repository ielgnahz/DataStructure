package sdu.edu.leetcode.medium;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        List<int[]> result = new ArrayList<>();
        for(int i = 0;i < n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        for(int i = 0,j = 0;i < n;i++){
            if(i == n - 1 || start[i + 1] > end[i]){
                result.add(new int[]{start[j], end[i]});
                j = i + 1;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] merge2(int[][] intervals){
        if (intervals == null || intervals.length == 0) return new int[][] {};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offerLast(intervals[0]);
        for(int i = 1;i < intervals.length;i++){
            if(queue.peekLast()[1] >= intervals[i][0]){
                queue.peekLast()[1] = Math.max(intervals[i][1], queue.peekLast()[1]);
            }else{
                queue.offerLast(intervals[i]);
            }
        }
        return queue.toArray(new int[queue.size()][]);
    }

}
