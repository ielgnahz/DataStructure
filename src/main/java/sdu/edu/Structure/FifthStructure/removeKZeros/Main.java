package sdu.edu.Structure.FifthStructure.removeKZeros;

public class Main {
	public String removeKZeros(String arr, int k) {
		char[] str = arr.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '0') {
				count++;
			} else {
				if (count != k) {
					while (count-- != 0) {
						sb.append("0");
					}
				}
				count = 0;
				sb.append(str[i]);
			}

		}
		if (count != k) {
			while (count-- != 0) {
				sb.append('0');
			}
		}
		return sb.toString();
	}

	// public String removeKZero(String str,int k){
	// char[] chas = str.toCharArray();
	// int count = 0;
	// int start = -1;
	// for(int i = 0;i!=chas.length;i++){
	// if(chas[i] == '0'){
	// count++;
	// start = start == -1?i:start;
	// }else{
	// if(count == k){
	// while(count-- != 0)
	// chas[start++] = 0;
	//
	// }
	// count = 0;
	// start = -1;
	// }
	// }
	// if(count == k){
	// while(count-- != 0)
	// chas[start++] = 0;
	//
	// }
	// return String.valueOf(chas);
	// }

	public static void main(String[] args) {
		System.out.println(new Main().removeKZeros("A0000B000", 3));
	}
}
