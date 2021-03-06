package sdu.edu.Structure.EighthStructure.getLessIndex;

public class Main1 {
	public int getLessIndex(int[] arr) {
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if(arr[mid] > arr[mid-1]){
				right = mid -1;
			}else if(arr[mid] > arr[mid+1]){
				left = mid + 1;
			}else{
				return mid;
			}
		}
		return left;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().getLessIndex(new int[]{2,2,3,4,5,6,7}));
	}
}
