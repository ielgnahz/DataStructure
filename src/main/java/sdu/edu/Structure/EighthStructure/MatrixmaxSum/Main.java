package sdu.edu.Structure.EighthStructure.MatrixmaxSum;

public class Main {
	public int MatrixmaxSum(int[][] arr){
		int[] s = null;
		int cur = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			s = new int[arr[0].length];
			for (int j = i; j < arr.length; j++) {
				cur = 0;
				for (int k = 0; k < arr[0].length; k++) {
					s[k] +=arr[j][k];
					cur += s[k];
					max = Math.max(max, cur);
					cur = cur < 0?0:cur;
				}
			}
		}
		return max;
	}
}
