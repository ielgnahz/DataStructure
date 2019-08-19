package sdu.edu.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        QuickSort(new int[]{73, 22, 93, 55, 14, 28, 65, 39, 81});
    }

    public static void QuickSort(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int right = stack.pop();
            int left = stack.pop();

            if(left > right){
                continue;
            }

            int pivot = Partition(arr, left, right);
            stack.push(left);
            stack.push(pivot - 1);

            stack.push(pivot + 1);
            stack.push(right);
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int Partition(int[] arr, int left,int right){
        int start = left - 1;
        int k = new Random().nextInt(right - left + 1) + left;
        swap(arr, right, k);
        for(int i = left;i < right;i++){
            if(arr[i] <= arr[right]){
                swap(arr, ++start, i);
            }
        }
        swap(arr, ++start, right);
        return start;
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}