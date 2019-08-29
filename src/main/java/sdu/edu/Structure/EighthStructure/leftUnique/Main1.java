package sdu.edu.Structure.EighthStructure.leftUnique;

public class Main1 {
	public void leftUnique(int[] arr) {
		int i = 1;
		int u = 0;
		while (arr[i++] != u) {
			swap(arr, i-1, ++u);
		}
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public void sort(int[] arr){
		int index = 0;
		int left = -1;
		int right = arr.length;
		while(index != right){
			if(arr[index]  == 0){
				swap(arr, ++left, index++);
			}else if(arr[index] == 2){
				swap(arr, index, --right);
			}else{
				index++;
			}
		}
	}
}
