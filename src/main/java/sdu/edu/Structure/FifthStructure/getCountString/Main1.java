package sdu.edu.Structure.FifthStructure.getCountString;

public class Main1 {
	public String getCountString(String arr) {
		char[] str = arr.toCharArray();
		int num = 1;
		String res = str[0] + "";
		for (int i = 1; i < str.length; i++) {
			if (str[i - 1] == str[i]) {
				num++;
			} else {
				res += "_" + num + "_" + str[i];
				num = 1;
			}
		}
		res += "_" + num;
		return res;
	}

	public char getCharAt(String arr, int k) {
		char[] str = arr.toCharArray();
		boolean flag = false;
		int num = 0;
		int sum = 0;
		char a = 0;
		for (int i = 0; i < str.length; i++) {
//			if (str[i] == '_') {
//				flag = !flag;
//			} else if (flag) {
//				num = num * 10 + str[i] - '0';
//			} else {
//				if (k > sum && k <= sum + num) {
//					return a;
//				}
//				sum += num;
//				num = 0;
//				a = str[i];
//			}
			if(str[i] == '_'){
				flag = !flag;
			}else if(!flag){
				sum+=num;
				if(sum > k){
					return a;
				}
				num = 0;
				a = str[i];
			}else{
				num = num * 10 + str[i] - '0';
			}

		}
		return k < sum + num ? a : 0;
	}

	public static void main(String[] args) {
		System.out.println(new Main1().getCharAt("a_3_b_2_a_1_d_3_f_2_c_1", 5));
	}
}
