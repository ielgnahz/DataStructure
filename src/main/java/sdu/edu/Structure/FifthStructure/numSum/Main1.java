package sdu.edu.Structure.FifthStructure.numSum;

public class Main1 {
	public int numSum(String arr) {
		char[] str = arr.toCharArray();
		boolean flag = true;
		int num = 0;
		int sum = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '-') {
				sum+=flag?num:-num;
				num = 0;
				flag = !flag;
			} else if (str[i] >= '0' && str[i] <= '9') {
				num = num * 10 + str[i] - '0';
			} else {
				sum += flag ? num : -num;
				flag = true;
				num = 0;
			}

		}
		sum += flag?num:-num;
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Main1().numSum("A-1B-g--2C--D6E"));
	}
}
