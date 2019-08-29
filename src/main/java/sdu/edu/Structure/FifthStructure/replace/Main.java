package sdu.edu.Structure.FifthStructure.replace;

public class Main {
	public String replace(String str, String from, String to) {
		int match = 0;
		char[] str1 = str.toCharArray();
		char[] from1 = from.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str1.length; i++) {
			if (str1[i] == from1[match++]) {
				if (match == from1.length) {
					while (match-- != 0) {
						str1[i - match] = 0;
					}
					match = 0;
				}
			} else {
				match = 0;
			}
		}
		for(int i = 0;i<str1.length;i++){
			if(str1[i] != 0){
				sb.append(str1[i]);
			}else if(str1[i] == 0 && (i == 0 || str1[i-1]!=0)){
				sb.append(to);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(new Main().replace("123abcabc", "abc", "X"));
	}
}
