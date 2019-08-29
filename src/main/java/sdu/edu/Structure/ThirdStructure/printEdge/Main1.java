package sdu.edu.Structure.ThirdStructure.printEdge;

public class Main1 {
	public void printEdge1(Node head) {
		int height = getHeight(head, 0);
		Node[][] edgeMap =new Node[height][2];
		setEdgeMap(edgeMap, head, 0);
		for(int i = 0;i<edgeMap.length;i++){
			System.out.println(edgeMap[i][0].value);
		}
		printLeftNotInMap(edgeMap, head, 0);
		for(int i = edgeMap.length-1;i>=0;i--){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1].value);
			}
		}
	}

	public void setEdgeMap(Node[][] edge, Node head, int height) {
		if(head == null){
			return;
		}
		edge[height][0] = edge[height][0] == null?head:edge[height][0];
		edge[height][1] = head;
		setEdgeMap(edge, head.left, height+1);
		setEdgeMap(edge, head.right, height+1);
	}

	public int getHeight(Node head, int height) {
		if(head == null){
			return height;
		}
		return Math.max(getHeight(head.left, height+1), getHeight(head.right, height+1));
	}

	public void printLeftNotInMap(Node[][] edge, Node head, int height) {
		if(head == null){
			return;
		}
		if(head.left == null && head.right == null && head != edge[height][0] && head != edge[height][1]){
			System.out.println(head.value);
		}
		printLeftNotInMap(edge, head.left, height+1);
		printLeftNotInMap(edge, head.right, height+1);
	}

	public void printEdge2(Node head) {
		if(head == null){
			return;
		}
		System.out.println(head.value);
		if(head.left != null && head.right != null){
			printLeft(head.left, true);
			printRight(head.right, true);
		}else{
			printEdge2(head.left == null?head.right:head.left);
		}
	}

	public void printLeft(Node head, boolean flag) {
		if(head == null){
			return;
		}
		if(flag || (head.left == null && head.right == null)){
			System.out.println(head.value);
		}
		printLeft(head.left, flag);
		printLeft(head.right, flag & head.left == null);
	}

	public void printRight(Node head, boolean flag) {
		if(head == null){
			return;
		}
		printRight(head.left, flag & head.right == null);
		printRight(head.right, flag);
		if(flag || (head.left == null && head.right == null)){
			System.out.println(head.value);
		}
	}

}
