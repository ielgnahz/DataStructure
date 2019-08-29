package sdu.edu.leetcode.medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class findKthLargest {

    public static int findKthLargest(int[] nums, int k){
        int left = 0;
        int right = nums.length;
        while(left <right){
            int start = left;
            int end = right - 1;
            int tail = start - 1;
            for(int i = start;i < end;i++){
                if(nums[i] >= nums[end]){
                    swap(nums, ++tail, i);
                }
            }
            swap(nums, ++tail, end);

            if(tail == k - 1){
                return nums[tail];
            }else if(tail < k-1){
                left = tail + 1;
            }else{
                right = tail;
            }
        }
        return 0;
    }

    public static int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0;i < nums.length;i++){
            queue.add(nums[i]);
            while(queue.size() > k){
                queue.poll();
            }
        }
        Queue<Integer> q = new LinkedList<>();
        return queue.peek();
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
