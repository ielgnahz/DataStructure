package sdu.edu.Structure.EighthStructure.leftUnique;

public class Main {
	public void leftUnique(int[] arr){
		int u = 0;
		int i = 1;
		while(i != arr.length){
			if(arr[i++]!= arr[u]){
				swap(arr, i-1, ++u);
			}
		}
	}
	public void swap(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public void sort(int[] arr){
		int left = -1;
		int index = 0;
		int right = arr.length;
		while(index < right){
			if(arr[index] == 0){
				swap(arr, ++left, index++);
			}else if(arr[index] == 2){
				swap(arr, index, --right);
			}else{
				index++;
			}
		}
	}
}
