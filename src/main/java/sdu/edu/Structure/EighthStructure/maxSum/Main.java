package sdu.edu.Structure.EighthStructure.maxSum;

public class Main {
	public int maxSum(int[] arr){
		int cur = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			cur += arr[i];
			max = Math.max(cur, max);
			cur = cur < 0?0:cur;
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(new Main().maxSum(new int[]{1,-2,3,5,-2,6,-1}));
	}
}
