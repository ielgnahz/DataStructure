package sdu.edu.Structure.ThirdStructure.printEdge;

public class Main {
	public void printEdge1(Node head){
		int height = getHeight(head,0);
		Node edgemap[][] = new Node[height][2];
		setEdgeMap(edgemap,0,head);
		for(int i =0;i<edgemap.length;i++){
			System.out.println(edgemap[i][0].value);
		}
		printLeafNotInMap(edgemap,0,head);
		for(int i = height - 1;i>=0;i--){
			if(edgemap[i][1] != edgemap[i][0]){
				System.out.println(edgemap[i][1].value);
			}
		}
	}
	public int getHeight(Node head,int l){
		if(head == null){
			return l;
		}
		return Math.max(getHeight(head.left,l+1), getHeight(head.right, l+1));
	}
	
	public void setEdgeMap(Node[][] edgemap,int l,Node head){
		if(head == null){
			return;
		}
		edgemap[l][0] = edgemap[l][0] == null?head:edgemap[l][0];
		edgemap[l][1] = head;
		setEdgeMap(edgemap,l+1,head.left);
		setEdgeMap(edgemap, l+1, head.right);
	}
	public void printLeafNotInMap(Node [][]edgemap,int l,Node head){
		if(head == null){
			return;
		}
		if(head.left == null && head.right == null && head!= edgemap[l][0] && head != edgemap[l][1]){
			System.out.println(head.value);
		}
		printLeafNotInMap(edgemap,l+1,head.left);
		printLeafNotInMap(edgemap, l+1, head.right);
	}
	
	public void printEdge2(Node head){
		if(head == null){
			return;
		}
		System.out.println(head.value);
		if(head.left != null && head.right != null){
			printLeftEdge(head.left,true);
			printRightEdge(head.right,true);
		}else{
			printEdge2(head.left==null?head.right:head.left);
		}
	}
	public void printLeftEdge(Node head,boolean flag){
		if(head == null){
			return;
		}
		if(flag || (head.left==null && head.right==null)){
			System.out.println(head.value);
		}
		printLeftEdge(head.left,flag);
		printLeftEdge(head.right,flag && head.left == null);
	}
	
	public void printRightEdge(Node head,boolean flag){
		if(head == null){
			return;
		}
		printRightEdge(head.left,flag && head.right == null);
		printRightEdge(head.right, flag);
		
		if(flag || (head.left == null && head.right == null)){
			System.out.println(head.value);
		}
	}
}
