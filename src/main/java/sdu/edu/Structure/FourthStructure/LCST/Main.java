package sdu.edu.Structure.FourthStructure.LCST;

public class Main {
	public int[][] getdp1(char[] str1,char[] str2){
		int[][] dp = new int[str1.length][str2.length];
		for(int i = 0;i<str1.length;i++){
			dp[i][0] = str1[i] == str2[0]?1:0;
		}
		for(int j = 0;j<str2.length;j++){
			dp[0][j] = str1[0] == str2[j]?1:0;
		}
		for(int i = 1;i<str1.length;i++){
			for(int j = 1;j<str2.length;j++){
				if(str1[i] == str2[j]){
					dp[i][j] = dp[i-1][j-1]+1;
				}
			}
		}
		return dp;
	}
	
	public String lcst1(String str1,String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int m = arr1.length;
		int[][] dp = getdp1(arr1, arr2);
		int max = 0;
		int index = 0;
		for(int i = 0;i<dp.length;i++){
			for(int j = 0;j<dp[0].length;j++){
				if(dp[i][j]>max){
					max = dp[i][j];
					index = i;
				}
			}
		}
		return str1.substring(m-index-1, m-index+max-1);
//		return str1.substring(index-max+1,index+1);
	}
	
	public String lcst2(String str1,String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int row = 0;
		int col = arr2.length-1;
		int max = 0;
		int index = 0;
		while(row < arr1.length){
			int i = row;
			int j = col;
			int len = 0;
			while(i < arr1.length && j < arr2.length){
				if(arr1[i] == arr2[j]){
					len++;
				}else{
					len = 0;
				}
				if(len > max){
					max = len;
					index = i;
				}
				i++;
				j++;
			}
			if(col>0){
				col--;
			}else{
				row++;
			}
		}
		return str1.substring(index-max+1, index+1);
		
		
	}
	
	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "bebcd";
		System.out.println(new Main().lcst2(str1, str2));
	}
}
