package sdu.edu.Sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class BubbleSort {

    public static void BubbleSort(int[] arr){
        int n = arr.length;
        for(int i = n-1;i >= 0;i--){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j+1, j);
                }
            }
        }
    }

    public static void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
