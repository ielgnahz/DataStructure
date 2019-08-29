package sdu.edu.Structure.FifthStructure.isRotation;

public class Main {
	public boolean isRotation(String a,String b){
		if(a.length() != b.length()){
			return false;
		}
		String b2 = b+b;
		return getIndex(b2, a) == -1?false:true;
	}
	public int[] getNext(char[] str){
		int n = 0;
		int[] next = new int[str.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		while(pos < next.length){
			if(str[pos-1] == str[n]){
				next[pos++] = ++n;
			}else if(n>0){
				n = next[n];
			}else{
				next[pos++] = 0;
			}
		}
		return next;
	}
	//a中是否包含b
	public int getIndex(String a,String b){
		char[] str1 = a.toCharArray();
		char[] str2 = b.toCharArray();
		int[] next = getNext(str2);
		int pos1 = 0;
		int pos2 = 0;
		while(pos1 < str1.length && pos2 < str2.length){
			if(str1[pos1] == str2[pos2]){
				pos1++;
				pos2++;
			}else if(pos2 != 0){
				pos2 = next[pos2];
			}else{
				pos1++;
			}
		}
		return pos2 == str2.length?pos1-pos2:-1;
	}
	public static void main(String[] args) {
		System.out.println(new Main().isRotation("12345", "15234"));
	}
}
