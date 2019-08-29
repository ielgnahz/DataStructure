package sdu.edu.Structure.FifthStructure.removeKZeros;

public class Main1 {
	public String removeKZeros(String arr, int k) {
		char[] str = arr.toCharArray();
		int match = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '0') {
				match++;
			} else {
				sb.append(str[i]);
				if (match != k) {
					while (match-- != 0) {
						sb.append('0');
					}
				}
				match = 0;
			}
		}
		if (match != k) {
			while (match-- != 0) {
				sb.append('0');
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(new Main().removeKZeros("A0000B000", 3));
	}
}
