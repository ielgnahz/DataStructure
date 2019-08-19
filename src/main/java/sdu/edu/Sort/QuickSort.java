package sdu.edu.Sort;

public class QuickSort {

    public static void QuickSort(int[] arr){
        QuickSort(arr, 0, arr.length - 1);
    }

    public static void QuickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = Partition(arr,start,end);
        QuickSort(arr, start, pivot - 1);
        QuickSort(arr, pivot + 1, end);
    }

    public static int Partition(int[] arr, int start, int end){
        int tail = start - 1;
        for(int i = start;i < end;i++){
            if(arr[i] <= arr[end]){
                swap(arr, i, ++tail);
            }
        }
        swap(arr, ++tail, end);
        return tail;
    }

    public static void swap(int[] arr,int start,int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        QuickSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

}
