package sdu.edu.Structure.FifthStructure.getPalindromel;

public class Main1 {
	public int[][] getDP(String arr){
		char[] str = arr.toCharArray();
		int[][] dp = new int[str.length][str.length];
		for(int j = 1;j < dp.length;j++){
			dp[j-1][j] = str[j-1] == str[j]?0:1;
			for(int i = j-2;i>=0;i--){
				if(str[i] == str[j]){
					dp[i][j] = dp[i+1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
				}
				
			}
		}
		return dp;
	}
	public String getPalindromel(String arr){
		if(arr == null){
			return null;
		}
		char[] str = arr.toCharArray();
		int[][] dp = getDP(arr);
		char[] res = new char[str.length+dp[0][str.length-1]];
		int start = 0;
		int end = str.length-1;
		int resl = 0;
		int resr = res.length-1;
		while(start <= end){
			if(str[start] == str[end]){
				res[resl++] = str[start++];
				res[resr--] = str[end--];
			}else{
				if(dp[start+1][end] > dp[start][end-1]){
					res[resl++] = str[end];
					res[resr--] = str[end--];
				}else{
					res[resl++] = str[start];
					res[resr--] = str[start++];
				}
			}
		}
		return String.valueOf(res);
	}
	public String getPalindromel(String arr,String arrlps){
		char[] str = arr.toCharArray();
		char[] strlps = arrlps.toCharArray();
		char[] res = new char[2 * str.length - strlps.length];
		int strl = 0;
		int strr = str.length-1;
		int resl = 0;
		int resr = res.length-1;
		int lpsl = 0;
		int lpsr = strlps.length-1;
		int tmpl = 0;
		int tmpr = 0;
		while(lpsl <= lpsr){
			tmpl = strl;
			tmpr = strr;
			while(str[strl] != strlps[lpsl]){
				strl++;
			}
			while(str[strr] != strlps[lpsr]){
				strr--;
			}
			set(str,tmpl,strl,tmpr,strr,res,resl,resr);
			resl += strl - tmpl + tmpr - strr;
			resr -= strl - tmpl + tmpr - strr;
			res[resl++] = str[strl++];
			res[resr--] = str[strr--];
			lpsl++;
			lpsr--;
		}
		return String.valueOf(res);
	}
	public void set(char[] str,int tmpl,int strl,int tmpr,int strr,char[] res,int resl,int resr){
		for(int i = tmpl;i<strl;i++){
			res[resl++] = str[i];
			res[resr--] = str[i];
		}
		for(int i = tmpr;i>strr;i--){
			res[resl++] = str[i];
			res[resr--] = str[i];
		}
		
	}
	public static void main(String[] args) {
		System.out.println(new Main1().getPalindromel("A1B21C","121"));
	}
}
