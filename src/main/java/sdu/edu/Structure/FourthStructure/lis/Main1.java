package sdu.edu.Structure.FourthStructure.lis;

public class Main1 {
	public int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[j] > max) {
					max = dp[j];
				}
			}
			dp[i] = max + 1;
		}
		return dp;
	}

	public int[] getdp2(int[] arr) {
		int n = arr.length;
		int[] end = new int[n];
		int[] dp = new int[n];
		dp[0] = 1;
		end[0] = arr[0];
		int l = 0;
		int r = 0;
		int right = 0;
		for(int i = 1;i<n;i++){
			l = 0;
			r = right;
			while(l<=r){
				int m = (l+r)/2;
				if(arr[i]>end[m]){
					l=m+1;
				}else{
					r = m-1;
				}
			}
			end[l] = arr[i];
			right = Math.max(right, l);
			dp[i] = l+1;
		}
		return dp;
	}

	public int[] generateLIS(int[] arr, int[] dp) {
		int index = 0;
		int len = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];

		for (int i = index - 1; i >= 0; i--) {
			if (dp[i] == dp[index] - 1 && arr[i] < arr[index]) {
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}

	public static void main(String[] args) {
		int[] res = new int[] { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		int[] dp = new Main().getdp2(res);
		 int[] lis = new Main1().generateLIS(res, dp);
		for (int i = 0; i < dp.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		 System.out.println();
		 for (int i = 0; i < lis.length; i++) {
		 System.out.print(lis[i]+" ");
		 }
	}
}
