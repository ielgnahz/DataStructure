package sdu.edu.Structure.EighthStructure.maxSum;

public class Main1 {
	public int maxSum(int[] arr) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			max = Math.max(sum, max);
			sum = sum < 0 ? 0 : sum;
		}
		return max;
	}
}
