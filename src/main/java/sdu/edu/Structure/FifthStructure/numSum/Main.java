package sdu.edu.Structure.FifthStructure.numSum;

public class Main {
	public int numSum(String arr){
		char[] str = arr.toCharArray();
		int num = 0;
		int res = 0;
		boolean flag = true;
		for(int i = 0;i<str.length;i++){
			if(str[i]>='0' && str[i] <= '9'){
				num = num*10 + str[i]-'0';
			}else if(str[i] == '-'){
				res +=(flag?num:-num);
				num = 0;
				flag = !flag;
			}else{
				res+=(flag?num:-num);
				num = 0;
				flag = true;
			}
		}
		res+=(flag?num:-num);
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new Main().numSum("A-1B-g--2C--D6E"));
	}
}
