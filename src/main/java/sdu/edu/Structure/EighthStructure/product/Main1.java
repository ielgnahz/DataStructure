package sdu.edu.Structure.EighthStructure.product;

public class Main1 {
	public int[] product1(int[] arr){
		int[]res = new int[arr.length];
		int all = 1;
		int count = 0;
		for (int i = 0; i < res.length; i++) {
			if(arr[i] == 0){
				count++;
			}else{
				all *= arr[i];
			}
		}
		if(count == 0){
			for (int i = 0; i < res.length; i++) {
				res[i] = all/arr[i];
			}
		}else if(count == 1){
			for (int i = 0; i < res.length; i++) {
				if(arr[i] == 0){
					res[i] = all;
				}
			}
		}
		return res;
	}
	
	public int[] product2(int[] arr){
		int[] res = new int[arr.length];
		res[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res[i] =arr[i] * res[i-1];
		}
		int tmp = 1;
		for (int i = res.length-2; i>=0; i--) {
			res[i+1] = res[i] * tmp;
			tmp *= arr[i+1];
		}
		res[0] = tmp;
		return res;
	}
	public static void main(String[] args) {
		int[] res = new Main1().product2(new int[]{2,3,1,4});
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
		
	}
}
