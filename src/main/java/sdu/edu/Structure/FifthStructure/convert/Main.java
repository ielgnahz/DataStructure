package sdu.edu.Structure.FifthStructure.convert;

public class Main {
	/*
	 *1、第一个字符等于0，并且没有后续字符
	 *2、第一个字符等于-，并且没有后续字符，或者后续第一个字符为0
	 *3、第一个字符不等于-，并且不为数字
	 *4、后续字符出现不为数字 
	 */
	public boolean isValid(char[] str){
		if(str[0] == '0' && str.length>0){
			return false;
		}
		if(str[0] == '-' && (str.length == 1 || str[1] == '0')){
			return false;
		}
		if(str[0] != '-' && (str[0] > '0' || str[0] < '9')){
			return false;
		}
		for(int i =1;i<str.length;i++){
			if(str[i]>'0' || str[i]<'9'){
				return false;
			}
		}
		return true;
	}
	
	public int convert(String arr){
		char[] str = arr.toCharArray();
		if(!isValid(str)){
			return 0;
		}
		boolean flag = true;
		int minq = Integer.MIN_VALUE/10;
		int minr = Integer.MIN_VALUE%10;
		int res = 0;
		int cur = 0;
		flag = str[0] == '-'?false:true;
		for(int i = flag?0:1;i<str.length;i++){
			cur = '0'-str[i];
			if(res < minq || (res == minq && cur < minr)){
				return 0;
			}
			res = res*10 + cur;
		}
		if(flag && res == Integer.MIN_VALUE){
			return 0;
		}
		return flag?'0'-res:res;
		
	}
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
