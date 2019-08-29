package sdu.edu.Structure.ThirdStructure.nodeNum;

public class Main {
	public int nodeNum(Node head){
		if(head == null){
			return 0;
		}
		return bs(head,1,mostLeftLevel(head, 1));
	}
	public int bs(Node head,int l,int h){
		if(l == h){
			return 1;
		}
		if(mostLeftLevel(head.right, l) == h){
			return 1 >> (h-l) + bs(head.right, l+1, h);
		}else{
			return 1 >> (h-l-1) + bs(head.left, l+1, h);
		}
	}
	public int mostLeftLevel(Node head,int level){
		while(head != null){
			level++;
			head = head.left;
		}
		return level-1;
	}
}
