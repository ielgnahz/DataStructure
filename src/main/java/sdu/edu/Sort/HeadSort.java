package sdu.edu.Sort;

public class HeadSort {
    public static void HeadSort(int[] arr){
        BuildHead(arr);
        int n = arr.length;
        while(--n > 0){
            swap(arr, 0, n);
//            HeadSortRecursion(arr, 0, n);
            HeadSortInteration(arr, 0, n);
        }
    }

    public static void BuildHead(int[] arr){
        for(int i = arr.length / 2 - 1;i >=0;i--){
//            HeadSortRecursion(arr, i, arr.length);
            HeadSortInteration(arr, i, arr.length);
        }
    }

    public static void HeadSortRecursion(int[] arr,int i,int size){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left <size && arr[left] > arr[max]){
            max = left;
        }

        if(right < size && arr[right] > arr[max]){
            max = right;
        }
        if(max != i){
            swap(arr, max, i);
            HeadSortRecursion(arr, max, size);
        }
    }

    public static void HeadSortInteration(int[] arr, int i, int size){
        for(int k = 2 * i + 1;k < size;k = k * 2 + 1){
            if(k + 1 < size && arr[k + 1] > arr[k]){
                k = k+1;
            }
            if(arr[k] > arr[i]){
                swap(arr, k, i);
                i = k;
            }else{
                break;
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        HeadSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
