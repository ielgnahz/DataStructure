package sdu.edu.Structure.FifthStructure.minCut;

public class Main {
	public int minCut(String arr){
		char[] str = arr.toCharArray();
		int len = str.length;
		boolean[][] flag = new boolean[len][len];
		int[] dp = new int[len+1];
		dp[len] = -1;
		for (int i = len-1; i >=0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for(int j = i;j<len;j++){
				if(str[i] == str[j] && (j-i<2 || flag[i+1][j-1])){
					flag[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0];
	}
	public static void main(String[] args ) {
		System.out.println(new Main().minCut("ABA"));
	}
}
