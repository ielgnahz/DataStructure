package sdu.edu.Structure.FourthStructure.num;

public class Main {
	public int num(String arr){
		char[] str = arr.toCharArray();
		return process(str,0);
	}
	public int process(char[] str,int index){
		if(index == str.length){
			return 1;
		}
		if(str[index] == '0'){
			return 0;
		}
		int res = process(str, index+1);
		if(index+1<str.length && (str[index]-'0')*10+str[index+1]-'0'<27){
			res+=process(str, index+2);
		}
		return res;
	}
	
	public int num1(String arr){
		char[] str = arr.toCharArray();
		int m = str.length;
		int cur = str[m-1]=='0'?0:1;
		int tmp = 0;
		int next = 1;
		for(int i = m-2;i>=0;i--){
			if(str[i] == '0'){
				next = cur;
				cur = 0;
			}else{
				tmp = cur;
				if((str[i]-'0')*10+(str[i+1]-'0')<27){
					cur+=next;
				}
				next = tmp;
			}
		}
		return cur;
	}
	public static void main(String[] args) {
		System.out.println(new Main().num("1111"));
	}
	
}
