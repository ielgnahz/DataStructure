package sdu.edu.Structure.EighthStructure.modify;

public class Main {
	public void modify(int[] arr){
		int even = 0;
		int odd = 1;
		int end = arr.length-1;
		while(even <= end && odd <= end){
			if((arr[end] & 1) == 0){
				swap(arr, odd, end);
				odd +=2;
			}else{
				swap(arr, even, end);
				even+=2;
			}
		}
	}
	public void swap(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
