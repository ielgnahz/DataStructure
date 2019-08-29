package sdu.edu.Structure.ThirdStructure.nodeNum;

public class Main1 {
	public int nodeNum(Node head){
		if(head == null){
			return 0;
		}
		return bs(head,1,mostLevel(head, 1));
	}
	public int bs(Node head,int l,int h){
		if(head == null){
			return 0;
		}
		if(mostLevel(head.right, l+1) == h){
			return 1 << (h-l) + bs(head.right, l+1, h);
		}else{
			return 1 << (h-l-1) + bs(head.left, l+1, h);
		}
 	}
	public int mostLevel(Node node,int level){
		if(node != null){
			node = node.left;
			level++;
		}
		return level-1;
	}
}
