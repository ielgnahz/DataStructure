package sdu.edu.Structure.EighthStructure.modify;

public class Main1 {
	public void modify(int[] arr) {
		int even = 0;
		int odd = 1;
		int end = arr.length - 1;
		while (even != end && odd != end) {
			if ((arr[end] & 1) == 0) {
				swap(arr, end, even);
				even += 2;
			} else {
				swap(arr, end, odd);
				odd += 2;
			}
		}
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
