package sdu.edu.Structure.FourthStructure.num;

public class Main1 {
	public int num(String arr) {
		char[] str = arr.toCharArray();
		if (str.length == 0) {
			return 0;
		}
		return process(str, 0);
	}

	public int process(char[] str, int i) {
		if (i == str.length) {
			return 1;
		}
		if (str[i] == '0') {
			return 0;
		}
		int res = process(str, i + 1);
		if (i + 1 < str.length && ((str[i] - '0') * 10 + str[i + 1] - '0') < 27) {
			res += process(str, i + 2);
		}
		return res;
	}
	
	public int num1(String arr){
		char[] str = arr.toCharArray();
		int cur = str[str.length-1] == '0'?0:1;
		int next = 1;
		int tmp = 0;
		for(int i = str.length-2;i>=0;i--){
			if(str[i] == '0'){
				next = cur;
				cur = 0;
			}else{
				tmp = cur;
				if((str[i]-'0')*10 + str[i+1]-'0'<27){
					cur+=next;
				}
				next = tmp;
			}
		}
		return cur;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().num1("11123"));
	}
}
