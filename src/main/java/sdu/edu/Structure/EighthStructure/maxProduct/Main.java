package sdu.edu.Structure.EighthStructure.maxProduct;

public class Main {
	public double maxProduct(int[] arr) {
		double max = arr[0];
		double min = arr[0];
		double res = 0;
		double maxEnd = 0;
		double minEnd = 0;
		for (int i = 1; i < arr.length; i++) {
			maxEnd = max * arr[i];
			minEnd = min * arr[i];
			max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
			min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
			res = Math.max(max, res);
		}
		return res;
	}
}
