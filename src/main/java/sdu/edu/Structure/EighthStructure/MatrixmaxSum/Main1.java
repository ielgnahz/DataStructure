package sdu.edu.Structure.EighthStructure.MatrixmaxSum;

public class Main1 {
	public void maxSum(int[][] arr){
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int[] res = null;
		for (int i = 0; i < arr.length; i++) {
			res = new int[arr.length];
			for (int j = i; j < arr.length; j++) {
				sum = 0;
				for (int k = 0; k < res.length; k++) {
					res[k] += arr[j][k];
					sum+=res[k];
					max = Math.max(max, sum);
					sum = sum < 0?0:sum;
				}
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		new Main1().maxSum(new int[][]{{-90,48,78},{64,-40,64},{-81,-7,66}});
	}
}
