package sdu.edu.Structure.ThirdStructure.isSubtree;

public class Main1 {
	public boolean isSubtree(Node t1, Node t2) {
		if(t1 == null || t2 == null){
			return false;
		}
		String r1 = serialByPre(t1);
		String r2 = serialByPre(t2);
		return getIndexOf(r1, r2)!=-1?true:false;
	}

	public String serialByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	public int getIndexOf(String r1, String r2) {
		int sl = 0;
		int ml = 0;
		char[] mm = r2.toCharArray();
		char[] sm = r1.toCharArray();
		int[] next = getNextArray(mm);
		while(sl < sm.length && ml < mm.length){
			if(mm[ml] == sm[sl]){
				ml++;
				sl++;
			}else if(next[ml] == -1){
				sl++;
			}else{
				ml = next[ml];
			}
		}
		return ml == mm.length?sl-ml:-1;
	}

	public int[] getNextArray(char[] mm) {
		int n = 0;
		int pre = 2;
		int[] next = new int[mm.length];
		next[0] = -1;
		next[1] = 0;
		while(pre < mm.length){
			if(next[pre-1] == next[n]){
				next[pre++] = ++n;
			}else if(n > 0){
				n = next[n];
			}else{
				next[pre++] = 0;
			}
		}
		return next;
	}
}
