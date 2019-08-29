package sdu.edu.Structure.FifthStructure.isMatch;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public boolean isValid(char[] s,char[] e){
		for (int i = 0; i < s.length; i++) {
			if(s[i] =='.' || s[i] == '*'){
				return false;
			}
		}
		for (int i = 0; i < e.length; i++) {
			if(e[i] =='*' && (i==0||e[i-1] =='*')){
				return false;
			}
		}
		return true;
	}
	public boolean isMatch(String str,String exp){
		return process(str.toCharArray(), exp.toCharArray(), 0, 0);
	}
	public boolean process(char[] s,char[] e,int si,int ei){
		if(ei == e.length){
			return si == s.length;
		}
		if(ei + 1 == e.length || e[ei+1] != '*'){
			return si != s.length && (s[si] == e[ei] || e[ei] =='.') && process(s, e, si+1, ei+1);
		}
		while(si != s.length && (e[ei] == s[si] || e[ei] =='.')){
			if(process(s, e, si+1, ei+2)){
				return true;
			}
			si++;
		}
		return process(s, e, si, ei+2);
	}
	
	public boolean isMatchDP(String str,String exp){
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		if(!isValid(s, e)){
			return false;
		}
		boolean[][] dp = initDP(s,e);
		for(int i = s.length-1;i>=0;i--){
			for(int j = e.length-2;j>=0;j--){
				if(e[j+1] != '*'){
					dp[i][j]  =(e[j] == '.' || e[j] == s[i]) && dp[i+1][j+1];
				}else{
					int si = i;
					while(si != s.length && (e[j] == s[si] || e[j] == '.')){
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
		dp[slen][elen] = true;
		for(int j = elen-2;j>=0;j= j-2){
			if(e[j]!='*' && e[j+1] =='*'){
				dp[slen][j] = true;
			}else{
				break;
			}
		}
		if(e[elen-1] == '.' || e[elen-1] == s[slen-1]){
			dp[slen-1][elen-1] = true;
		}
		return dp;
	}
	
	public static void main(String[] args) {
		System.out.println(new Main().isMatch("", ".*"));
		Deque<TreeNode> queue = new LinkedList<>();
	}
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
}
}
