package sdu.edu.Structure.FifthStructure.convert;

public class Main1 {
	public int convert(String arr){
		char[] str = arr.toCharArray();
		if(!isValid(str)){
			return 0;
		}
		int sum = str[0] == '-'?0:'0'-str[0];
		int cur = 0;
		int minl = Integer.MIN_VALUE/10;
		int minr = Integer.MAX_VALUE%10;
		boolean flag = str[0] == '-'?false:true;
		for(int i =1;i<str.length;i++){
			cur = '0'-str[i];
			if(sum < minl || (sum == minl && cur < minr)){
				return 0;
			}
			sum = sum*10 + cur;
		}
		if(flag && sum == Integer.MIN_VALUE){
			return 0;
		}
		return flag?-sum:sum;
	
	}
	public boolean isValid(char[] str){
		if(str[0] == '-' && ( str[1] == '0' || str.length == 1)){
			return false;
		}
		if(str[0] =='0' && str.length>1){
			return false;
		}
		if(str[0] != '-' && (str[0]<'0' || str[0]>'9')){
			return false;
		}
		for(int i = 1;i<str.length;i++){
			if(str[i]<'0' || str[i]>'9'){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().convert("123"));
	}
}
