package sdu.edu.Structure.FifthStructure.isRotation;

public class Main1 {
	public boolean isRotation(String a,String b){
		String b2 = b+b;
		return getIndexOf(b2,a) !=-1;
	}
	public int getIndexOf(String s,String m){
		char[] sm = s.toCharArray();
		char[] mm = m.toCharArray();
		int[] next = getNext(m);
		int si = 0;
		int mi = 0;
		while(si < sm.length && mi < mm.length){
			if(sm[si] == mm[mi]){
				si++;
				mi++;
			}else if(next[mi] != -1){
				mi = next[mi];
			}else{
				si++;
			}
		}
		return mi == mm.length?si-mi:-1;
		
	}
	public int[] getNext(String arr){
		char[] str = arr.toCharArray();
		int[] next = new int[str.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int n = 0;
		while(pos < str.length){
			if(str[pos-1] == str[n]){
				next[pos++] = ++n;
			}else if(n != 0){
				n = next[n];
			}else{
				next[pos++] = 0;
			}
		}
		return next;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().isRotation("cdab", "abcd"));
	}
}
