package sdu.edu.Structure.ThirdStructure.isBalance;

public class Main1 {
	public boolean isBalance(Node head) {
		if(head == null){
			return false;
		}
		boolean[] res = new boolean[1];
		getHeight(head,res,1);
		return res[0];
	}
	public int getHeight(Node head,boolean[] res,int level){
		if(head == null){
			return level;
		}
		int lH = getHeight(head.left, res, level+1);
		if(res[0]){
			return level;
		}
		int rH = getHeight(head.right, res, level+1);
		if(res[0]){
			return level;
		}
		if(Math.abs(lH - rH) > 1){
			res[0] = true;
		}
		return Math.max(lH, rH);  
	}

}
