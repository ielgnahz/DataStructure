package sdu.edu.Structure.EighthStructure.maxProduct;

public class Main1 {
	public double maxProduct(double[] arr){
		double max = arr[0];
		double min = arr[0];
		double maxEnd = 0;
		double minEnd = 0;
		double res = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			maxEnd = max * arr[i];
			minEnd = min * arr[i];
			max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
			min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
			res = Math.max(max, res);
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().maxProduct(new double[]{-2.5,4,0,3,0.5,8,-1}));
	}
}
