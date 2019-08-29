package sdu.edu.Structure.FourthStructure.LCSE;

public class Main {
	public int[][] getdp(char[] arr1,char[] arr2){
		if(arr1 == null || arr2 == null){
			return null;
		}
		int[][] dp = new int[arr1.length][arr2.length];
		for(int i = 1;i<dp.length;i++){
			dp[i][0] = Math.max(dp[i-1][0], arr1[i] == arr2[0]?1:0);
		}
		for(int j = 1;j<dp[0].length;j++){
			dp[0][j] = Math.max(dp[0][j-1], arr1[0] == arr2[j]?1:0);
		}
		for(int i = 1;i<dp.length;i++){
			for(int j = 1;j<dp[0].length;j++){
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(arr1[i] == arr2[j]){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
				}
			}
		}
		return dp;
	}
	
	public String lcse(String str1,String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[][] dp = getdp(arr1, arr2);
		int m = arr1.length-1;
		int n = arr2.length-1;
		char[] res = new char[dp[m][n]];
		int index = res.length-1;
		while(index>=0){
			if(m >0 && dp[m][n] == dp[m-1][n]){
				m--;
			}else if(n>0 &&dp[m][n] == dp[m][n-1]){
				n--;
			}else{
				res[index--] = arr1[m];
				m--;
				n--;
			}
		}
		return String.valueOf(res);
	}
	public static void main(String[] args) {
		String str1 = "1A2C3D4B56";
		String str2 = "B1D23CA45B6A";
		System.out.println(new Main().lcse(str1, str2));
	}
}
