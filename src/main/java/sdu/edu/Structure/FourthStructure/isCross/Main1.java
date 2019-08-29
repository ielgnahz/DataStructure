package sdu.edu.Structure.FourthStructure.isCross;

public class Main1 {
	public boolean isCorss(String arr1, String arr2, String aim) {
		char[] str1 = arr1.toCharArray();
		char[] str2 = arr2.toCharArray();
		char[] aims = aim.toCharArray();
		int m = str1.length;
		int n = str2.length;
		boolean[][] dp = new boolean[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			if (aims[i - 1] != str1[i]) {
				break;
			}
			dp[i][0] = true;
		}
		for(int j = 1;j<n+1;j++){
			if(str2[j] != aims[j-1]){
				break;
			}
			dp[0][j] = true;
		}
		for(int i = 1;i<m+1;i++){
			for(int j = 1;j<n+1;j++){
				if((dp[i-1][j] && str1[i-1] == aims[i+j-1]) || (dp[i][j-1] && str2[j-1] == aims[i+j-1])){
					dp[i][j] = true;
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		System.out.println(new Main().isCross("AB", "12", "AB12"));
	}
}
