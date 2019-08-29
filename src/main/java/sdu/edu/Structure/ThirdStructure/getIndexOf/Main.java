package sdu.edu.Structure.ThirdStructure.getIndexOf;

public class Main {
	public int getIndexOf(String s,String m){
		if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
			return -1;
		}
		char[] sm = s.toCharArray();
		char[] ms = m.toCharArray();
		int[] next = getNextArray(ms);
		int s1 = 0;
		int m1 = 0;
		while(s1< sm.length && m1< ms.length){
			if(sm[s1] == ms[m1]){
				s1++;
				m1++;
			}else if(next[m1] == -1){
				s1++;
			}else{
				m1 = next[m1];
			}
		}
		return m1 == ms.length?s1 - m1 : -1;
		
	}
	public int[] getNextArray(char[] ms){
		int next[] = new int[ms.length];
		int cn = 0;
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		while(pos < next.length){
			if(ms[pos -1] == ms[cn]){
				next[pos++] = ++cn;
			}else if(cn > 0){
				cn = next[cn];
			}else{
				next[pos++] = 0;
			}
		}
		return next;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public int[] getNextArray(char[] ms){
//		if(ms.length == 1){
//			return new int[]{-1};
//		}
//		int[] next = new int[ms.length];
//		next[0] = -1;
//		next[1] = 0;
//		int pos = 2;
//		int cn = 0;
//		while(pos < next.length){
//			if(ms[pos - 1 ] == ms[cn]){
//				next[pos++] =  ++cn;
//			}else if(cn > 0){
//				cn = next[cn];
//			}else{
//				next[pos++] = 0;
//			}
//		}
//		return next;
//	}
	public static void main(String[] args) {
		int[] next = new Main().getNextArray("ABDABCABDE".toCharArray());
		for (int i : next) {
			System.out.println(i);
		}
	}
}
