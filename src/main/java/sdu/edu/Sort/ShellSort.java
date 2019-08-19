package sdu.edu.Sort;

public class ShellSort {

    public static void ShellSort(int[] arr){
        int h = 1;
        int n = arr.length;
        while(h < n){
            h = h * 3 + 1;
        }
        while(h >= 1){
            for(int i = h;i < n;i += h){
                int j = i - h;
                int val = arr[i];
                while(j >= 0 && arr[j] > val){
                    arr[j + h] = arr[j];
                    j = j - h;
                }
                arr[j + h] = val;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        ShellSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

}
