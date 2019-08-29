package sdu.edu.Structure.FourthStructure.minCost;

public class Main {
	public int minCost(String str1,String str2,int ic,int rc,int dc){
		int m = str1.length();
		int n = str2.length();
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[][] dp = new int[m+1][n+1];
		for(int i = 1;i<m;i++){
			dp[i][0] = dp[i-1][0]+rc;
		}
		for(int j = 1;j<n;j++){
			dp[0][j] = dp[0][j-1]+ic;
		}
		for(int i =1;i<m;i++){
			for(int j = 1;j<n;j++){
				if(arr1[i] == arr2[j]){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = dp[i-1][j-1]+rc;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+dc);
				dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+ic);
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		System.out.println(new Main().minCost("ab12cd3", "abcdf", 5, 2, 3));
	}
}
