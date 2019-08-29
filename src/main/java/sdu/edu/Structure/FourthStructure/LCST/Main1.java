package sdu.edu.Structure.FourthStructure.LCST;

public class Main1 {
	public int[][] getdp(char[] str1,char[] str2){
		int m = str1.length;
		int n = str2.length;
		int[][] dp = new int[m][n];
		for(int i = 0;i<m;i++){
			dp[i][0] = str1[i] == str2[0]?1:0;
		}
		for(int j = 0;j<str2.length;j++){
			dp[0][j] = str1[0] == str2[j]?1:0;
		}
		for(int i = 1;i<m;i++){
			for(int j =1;j<n;j++){
				dp[i][j] = str1[i] == str1[j]?dp[i-1][j-1]+1:0;
			}
		}
		return dp;
	}
	
	public String lcst(String arr1,String arr2){
		char[] str1 = arr1.toCharArray();
		char[] str2 = arr2.toCharArray();
		int[][] dp = getdp(str1, str2);
		int max = 0;
		int l = 0;
		for(int i = 0;i<str1.length;i++){
			for(int j = 0;j<str2.length;j++){
				if(dp[i][j]>max){
					max = dp[i][j];
					l = i;
				}
			}
		}
		return arr1.substring(l-max+1,l+1);
	}
	
	public String lcst2(String arr1,String arr2){
		char[] str1 = arr1.toCharArray();
		char[] str2 = arr2.toCharArray();
		int m = str1.length;
		int n = str2.length;
		int row = 0;
		int col = n-1;
		int l = 0;
		int r = 0;
		int len = 0;
		int index = 0;
		int max = 0;
		while(row < m){
			l = row;
			r = col;
			len = 0;
			while(l < m && r < n){
				if(str1[l] == str2[r]){
					len++;
				}else{
					len = 0;
				}
				if(len > max){
					max = len;
					index = l;
				}
				l++;
				r++;
			}
			if(col>0){
				col--;
			}else{
				row++;
			}
		}
		return arr1.substring(index-max+1, index+1);
	}
	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "bebcd";
		System.out.println(new Main().lcst2(str1, str2));
	}
}
