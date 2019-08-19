package sdu.edu.Sort;

public class MergeSort {

    public static void MergeSort(int[] arr){
        int[] tmp = new int[arr.length];
//        MergeSortRecursion(arr, 0, arr.length - 1, tmp);
        MergeSortInteration(arr);
    }

    public static void MergeSortRecursion(int[] arr, int left, int right, int[] tmp){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        MergeSortRecursion(arr, left, mid, tmp);
        MergeSortRecursion(arr, mid + 1, right, tmp);
        Merge(arr, left, mid, right, tmp);
    }

    public static void MergeSortInteration(int[] arr){
        int left = 0;
        int mid = 0;
        int right = 0;
        int[] tmp = new int[arr.length];
        for(int i = 1;i < arr.length;i = i * 2){
            left = 0;
            while(left + i < arr.length){
                mid = left + i - 1;
                right = mid + i < arr.length?mid + i : arr.length - 1;
                Merge(arr, left, mid, right, tmp);
                left = right + 1;
            }
        }
    }

    public static void Merge(int[] arr,int left, int mid, int right, int[] tmp){
        int i = left;
        int j = mid + 1;
        int k = left;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            tmp[k++] = arr[i++];
        }
        while(j <= right){
            tmp[k++] = arr[j++];
        }
        while(left <= right){
            arr[left] = tmp[left++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        MergeSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

}
