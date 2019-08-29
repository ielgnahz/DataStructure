package sdu.edu.Structure.EighthStructure.getMinLength;

public class Main {
	public int getMinLength(int[] arr){
		int noMinIndex = -1;
		int min = arr[arr.length-1];
		for (int i = arr.length-2; i >=0; i--) {
			if(arr[i] > min){
				noMinIndex = i;
			}else{
				min = arr[i];
			}
		}
		if(noMinIndex == -1){
			return 0;
		}
		int noMaxIndex = -1;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < max){
				noMaxIndex = i;
			}else{
				max = arr[i];
			}
		}
		return noMaxIndex - noMinIndex + 1;
 	}
	public static void main(String[] args) {
		System.out.println(new Main().getMinLength(new int[]{1,5,3,4,2,6,7}));
	}
}
