package sdu.edu.Structure.FifthStructure.minCut;

public class Main1 {
	public int minCut(String arr){
		char[] str = arr.toCharArray();
		int len = str.length;
		boolean[][] p = new boolean[len+1][len+1];
		int[] dp = new int[len+1];
		dp[len] = -1;
		
		for(int i = len-1;i>=0;i--){
			dp[i] = Integer.MAX_VALUE;
			for(int j = i;j<len;j++){
				if(str[i] == str[j] && (j-i<2 || p[i+1][j-1])){
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0];
	}
	public static void main(String[] args) {
		System.out.println(new Main1().minCut("ACDCDCDAD"));
	}
}
