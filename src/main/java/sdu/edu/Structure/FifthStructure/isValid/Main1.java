package sdu.edu.Structure.FifthStructure.isValid;

public class Main1 {
	public boolean isValid(String arr){
		char[] str = arr.toCharArray();
		int state = 0;
		for(int i = 0;i<str.length;i++){
			if(str[i] != '(' || str[i] != ')'){
				return false;
			}
			if(str[i] == ')' && --state<0){
				return false;
			}
			if(str[i] == '('){
				state++;
			}
		}
		return state == 0;
	}
	public int maxLength(String arr){
		char[] str = arr.toCharArray();
		int[] dp = new int[str.length];
		dp[0] = 0;
		int pre = 0;
		int res = Integer.MIN_VALUE;
		for (int i = 1; i < str.length; i++) {
			if(str[i] ==')'){
				pre = i - dp[i-1] -1;
				if(str[pre] == '('){
					dp[i] = dp[i-1]+2 + (pre>0?dp[pre-1]:0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().maxLength("()()()()()"));
	}
}
