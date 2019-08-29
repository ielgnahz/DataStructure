package sdu.edu.Structure.ThirdStructure.bstTopoSize;

public class Main1 {
	public int bstTopoSize(Node head) {
		if(head == null){
			return 0;
		}
		int max = maxTopo(head,head);
		max = Math.max(max, bstTopoSize(head.left));
		max = Math.max(max, bstTopoSize(head.right));
		return max;
	}
	public int maxTopo(Node h,Node n){
		if(h != null && n != null && isBSTNode(h,n,n.value)){
			return maxTopo(h, n.left)+ maxTopo(h, n.right) + 1;
		}
		return 0;
	}
	public boolean isBSTNode(Node h,Node n,int value){
		if(h == null){
			return false;
		}
		if(h == n){
			return true;
		}
		return isBSTNode(h.value > value?h.left:h.right, n, value);
	}


}
