package sdu.edu.Structure.FourthStructure.win;

public class Main1 {
	public int win(int[] arr){
		if(arr == null){
			return 0;
		}
		return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
	}
	public int f(int[] arr,int i,int j){
		if(i == j){
			return arr[i];
		}
		return Math.max(arr[i]+s(arr, i+1, j), arr[j]+s(arr, i, j-1));
	}
	public int s(int[] arr,int i,int j){
		if(i == j){
			return 0;
		}
		return Math.min(f(arr, i+1, j), f(arr, i, j-1));
	}
	
	public int win1(int[] arr){
		if(arr == null){
			return 0;
		}
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for(int i = 0;i<arr.length;i++){
			f[i][i] = arr[i];
		}
//		for(int j = 0;j<arr.length;j++){
//			for(int i = j-1;i>=0;i--){
//				f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
//				s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
//			}
//		}
		for(int i = arr.length-1;i>=0;i--){
			for(int j = i+1;j<arr.length;j++){
				f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
			}
		}
		return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
	}
	
	public static void main(String[] args) {
		System.out.println(new Main1().win1(new int[]{1,2,100,4}));
	}
}
