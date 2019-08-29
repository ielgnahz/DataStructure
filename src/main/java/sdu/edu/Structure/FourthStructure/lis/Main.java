package sdu.edu.Structure.FourthStructure.lis;

public class Main {
	public int[] getdp1(int[] arr){
		int[] dp = new int[arr.length];
		for(int i = 0;i<arr.length;i++){
			dp[i] = 1;
			for(int j = 0;j<i;j++){
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp;
	}
	
	public int[] getdp2(int[] arr){
		int[] end = new int[arr.length];
		int l = 0;
		int r = 0;
		int[] dp = new int[arr.length];
		end[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		for(int i = 1;i<arr.length;i++){
			l = 0;
			r = right;
			while(l <= r){
				int m = (l+r)/2;
				if(arr[i] > end[m]){
					l = m+1;
				}else{
					r = m-1;
				}
			}
			end[l] = arr[i];
			right = Math.max(l, right);
			dp[i]=l+1;
		}
		return dp;
	}
	
	public int[] generateLIS(int[] arr,int[] dp){
		int index = 0;
		int max = 0;
		for(int i = 0;i<dp.length;i++){
			if(dp[i]>max){
				max = dp[i];
				index = i;
			}
		}
		int[] lis = new int[max];
		lis[--max] = arr[index];
		for(int i = index-1;i>=0;i--){
			if(arr[i]<arr[index] && dp[i] == dp[index]-1){
				index = i;
				lis[--max] = arr[i];
			}
		}
		return lis;
	}
	
	public int[] lis(int[] arr){
		if(arr == null){
			return null;
		}
		int[] dp = getdp1(arr);
		return generateLIS(arr, dp);                                                   
	}
	
	public static void main(String[] args) {
		int[] res = new int[]{2,1,5,3,6,4,8,9,7};
		int[] dp = new Main().getdp2(res);
//		int[] lis  = new Main().generateLIS(res, dp);
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i]+" ");
		}
//		System.out.println();
//		for (int i = 0; i < lis.length; i++) {
//			System.out.print(lis[i]+" ");
//		}
	}
}
