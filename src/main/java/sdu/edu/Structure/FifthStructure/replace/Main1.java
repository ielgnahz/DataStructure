package sdu.edu.Structure.FifthStructure.replace;

public class Main1 {
	public String replace(String arr,String from,String to){
		char[] str = arr.toCharArray();
		char[] fr = from.toCharArray();
		StringBuilder sb = new StringBuilder();
		int len = 0;
		for(int i = 0;i<str.length;i++){
			if(str[i] == fr[len]){
				len++;
				if(len == fr.length){
					sb.append(to);
					len = 0;
				}
			}else{
				if(len > 0){
					while(len-- != 0){
						sb.append(fr[i-len]);
					}
				}
				len = 0;
				sb.append(str[i]);
			}
		}
		if(len > 0){
			while(len-- != 0){
				sb.append(str[str.length-1-len]);
			}
		}
//		for(int i = 0;i<str.length;i++){
//			if(str[i] ==0 && (i == 0||str[i-1] != 0)){
//				sb.append(to);
//			}else if(str[i] != 0){
//				sb.append(str[i]);
//			}
//		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(new Main1().replace("123abcabc", "abc", "4567"));
	}
}
