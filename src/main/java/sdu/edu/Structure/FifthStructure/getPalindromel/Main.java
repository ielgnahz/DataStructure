package sdu.edu.Structure.FifthStructure.getPalindromel;

public class Main {
	public int[][] getDP(String arr) {
		char[] str = arr.toCharArray();
		int[][] dp = new int[str.length][str.length];
		for (int j = 1; j < dp.length; j++) {
			dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
			for (int i = j - 2; i >= 0; i--) {
				if (str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
				}
			}
		}
		return dp;
	}

	public String getPalindromel(String arr) {
		char[] str = arr.toCharArray();
		int[][] dp = getDP(arr);
		char[] chas = new char[str.length+dp[0][str.length-1]];
		int resl = 0;
		int resr = chas.length-1;
		int i = 0;
		int j = str.length-1;
		while(i<j){
			if(str[i] == str[j]){
				chas[resl++] = str[i++];
				chas[resr--] = str[j--];
			}else if(dp[i+1][j] > dp[i][j-1]){
				chas[resl++] = str[j];
				chas[resr--] = str[j--];
			}else{
				chas[resl++] = str[i];
				chas[resr--] = str[i++];
			}
		}
		return String.valueOf(chas);
	}
	public String getPalindromel(String str,String strlps){
		char[] arr = str.toCharArray();
		char[] strs = strlps.toCharArray();
		char[] res = new char[2 * arr.length - strs.length];
		int lpsl = 0;
		int lpsr = strs.length-1;
		int arrl = 0;
		int arrr = arr.length-1;
		int resl = 0;
		int resr = res.length-1;
		int tmpl = 0;
		int tmpr = 0;
		while(arrl <= arrr){
			tmpl = arrl;
			tmpr = arrr;
			while(arr[arrl] != strs[lpsl]){
				arrl++;
			}
			while(arr[arrr] != strs[lpsr]){
				arrr--;
			}
			set(res,arr,tmpl,tmpr,arrl,arrr,resl,resr);
			resl += arrl - tmpl + tmpr - arrr;
			resr -= arrl - tmpl + tmpr - arrr;
			res[resl++] = arr[arrl++];
			res[resr--] = arr[arrr--];
			lpsl++;
			lpsr--;
		}
		return String.valueOf(res);
	}
	public void set(char[] res,char[] arr,int tmpl,int tmpr,int arrl,int arrr,int resl,int resr){
		for(int i = tmpl;i<arrl;i++){
			res[resl++] = arr[i];
			res[resr--] = arr[i];
			
		}
		for(int i = tmpr;i>arrr;i--){
			res[resl++] = arr[i];
			res[resr--] = arr[i];
		}
//		for (int i = 0; i < res.length; i++) {
//			System.out.println(res[i]);
//		}
//		res[resl++] = arr[arrl];
//		res[resr--] = arr[arrr];
	}
	public static void main(String[] args) {
		System.out.println(new Main().getPalindromel("A1BC22DE1F","1221"));
	}
}
