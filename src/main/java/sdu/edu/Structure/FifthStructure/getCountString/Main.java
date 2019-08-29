package sdu.edu.Structure.FifthStructure.getCountString;

public class Main {
	public String getCount(String arr) {
		char[] str = arr.toCharArray();
		int num = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]);
		for (int i = 1; i < str.length; i++) {
			if (str[i] == str[i - 1]) {
				num++;
			} else {
				sb.append("_" + num + "_" + str[i]);
				num = 1;
			}
		}
		sb.append("_" + num);
		return sb.toString();
	}

	public char getCharAt(String res, int k) {
//		String arr = getCount(res);
		char[] str = res.toCharArray();
		int num = 0;
		int sum = 0;
		boolean flag = false;
		char c = str[0];
		for (int i = 1; i < str.length; i++) {
			if (str[i] == '_') {
				flag = !flag;
			} else {
				if (flag) {
					num =  num * 10 + str[i] - '0';
				} else {
					sum += num;
					if(sum > k){
						return c;
					}
					num = 0;
					c = str[i];
				}
			}
		}
		return sum+num>k?c:0;
	}

	public static void main(String[] args) {
		System.out.println(new Main().getCharAt("a_100_b_2_c_4", 105));
	}
}
