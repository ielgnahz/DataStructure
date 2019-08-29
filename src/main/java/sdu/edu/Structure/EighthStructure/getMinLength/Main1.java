package sdu.edu.Structure.EighthStructure.getMinLength;

public class Main1 {
	public int getMinLength(int[] arr){
		int min = arr[arr.length-1];
		int max = arr[0];
		int left = -1;
		int right = -1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < max){
				right = i;
			}else{
				max = arr[i];
			}
		}
		if(right == -1){
			return 0;
		}
		for (int i = arr.length-2; i >=0; i--) {
			if(arr[i] > min){
				left = i;
			}else{
				min = arr[i];
			}
		}
		return right - left + 1;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().getMinLength(new int[]{1,5,3,4,2,6,7}));
	}
}
