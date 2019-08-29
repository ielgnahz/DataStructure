package sdu.edu.Structure.ThirdStructure.isSubtree;

public class Main {
	public boolean isSubtree(Node h1,Node h2){
		String res1 = serialByPer(h1);
		String res2 = serialByPer(h2);
		return getIndexOf(res1, res2) != -1;
		
	}
	public String serialByPer(Node head){
		if(head == null){
			return "#!";
		}
		String res = head.value+"!";
		res += serialByPer(head.left);
		res += serialByPer(head.right);
		return res;
	}
	public int getIndexOf(String s,String m){
		if(s == null || m == null || m.length() == 0 || s.length() < m.length()){
			return 0;
		}
		char[] ss = s.toCharArray();
		char[] mm = m.toCharArray();
		int sl = 0;
		int ml = 0;
		int[] next = getNextArray(mm);
		while(sl < s.length() && ml < mm.length){
			if(ss[sl] == mm[ml]){
				sl++;
				ml++;
			}else if(next[ml] == -1){
				sl++;
			}else{
				ml = next[ml];
			}
		}
		return ml == mm.length?sl - ml:-1;
	}
	public int[] getNextArray(char[] mm){
		int next[] = new int[mm.length];
		int pos = 2;
		int cn = 0;
		next[0] = -1;
		next[1] = 0;
		while(pos < mm.length){
			if(mm[pos -1] == mm[cn]){
				next[pos++] = ++cn;
			}else if(cn > 0){
				cn = next[cn];
			}else{
				next[pos++] = 0;
			}
		}
		return next;
	}
}
