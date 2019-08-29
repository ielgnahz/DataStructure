package sdu.edu.Structure.EighthStructure.sort;

public class Main {
	public void sort1(int[] arr){
		int tmp = 0;
		int next = 0;
		for (int i = 0; i < arr.length; i++) {
			tmp = arr[i];
			while(arr[i] != i-1){
				next = arr[tmp-1];
				arr[tmp-1] = tmp;
				tmp = next;
			}
		}
	}
	public void sort2(int[] arr){
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			while(arr[i] != i-1){
				tmp = arr[i];
				arr[i] = arr[tmp-1];
				arr[tmp-1] = tmp;
			}
		}
	}
}
