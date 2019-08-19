package sdu.edu.Sort;

public class InsertSort {

    public static void InsertSort(int[] arr){
        int n = arr.length;
        for(int i = 1;i < n;i++){
            int j = i - 1;
            int val = arr[i];
            while(j >= 0 && val < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        InsertSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
