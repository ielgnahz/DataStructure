package sdu.edu.Sort;

public class SelectSort {

    public static void SelectSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n - 1;i++){
            int min = i;
            for(int j = i+1;j < n;j++){
                if(arr[min] >arr[j]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        SelectSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
