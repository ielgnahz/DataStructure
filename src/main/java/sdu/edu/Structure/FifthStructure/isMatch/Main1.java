package sdu.edu.Structure.FifthStructure.isMatch;

public class Main1 {
	public boolean isMatch(String str1,String str2){
		return process(str1.toCharArray(),str2.toCharArray(),0,0);
	}
	public boolean process(char[] str,char[] exp,int si,int ei){
		if(ei == exp.length){
			return si == str.length;
		}
		if(ei + 1 != exp.length && exp[ei+1]!='*'){
			return si != str.length && (exp[ei] == str[si] || exp[ei] =='.') && process(str, exp, si+1, ei+1);
		}
		while(exp[ei] == exp[si] || exp[ei] == '.'){
			if(process(str, exp, si, ei+2)){
				return true;
			}
			si++;
		}
		return process(str, exp, si, ei+2);
	}
	public boolean isMatch1(String str1,String str2){
		char[] str = str1.toCharArray();
		char[] exp = str2.toCharArray();
		boolean[][] dp = initDP(str,exp);
		for(int i = str.length-1;i>=0;i--){
			for(int j = exp.length-2;j>=0;j--){
				if(exp[j+1] != '*'){
					dp[i][j] = (exp[j] == str[i] || exp[j] =='.')&&dp[i+1][j+1];
				}else{
					int si = i;
					while(si != str.length && (exp[j] == str[i] || exp[j] =='.')){
						if(dp[si][j+2]){
							dp[i][j] = true;
							break;
						}
						si++;
					}
					if(!dp[i][j]){
						dp[i][j] = dp[si][j+2];
					}
				}
			}
		}
		return dp[0][0];
	}
	public boolean[][] initDP(char[] s,char[] e){
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = new boolean[slen+1][elen+1];
		dp[slen][slen] = true;
		for(int j = elen-1;j>=0;j = j-2){
			if(e[j] !='*' && e[j+1] =='*'){
				dp[slen][j] = true;
			}else{
				break;
			}
		}
		if(s[slen-1] == e[elen-1] || e[elen-1] == '.'){
			dp[slen-1][elen-1] = true;
		}
		return dp;
	}
}
