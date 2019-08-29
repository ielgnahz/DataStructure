package sdu.edu.Structure.ThirdStructure.biggestSubBST;

public class Main {
	public Node biggestSubBST(Node head){
		int []record = new int[3];
		return posOrder(head,record);
	}
	/**
	 * 
	 * @param head
	 * record[0] 搜索二叉树节点个数
	 * record[1] 最大值
	 * record[2] 最小值
	 */
	public Node posOrder(Node head,int[] record){
		if(head == null){
			record[0] = 0;
			record[1] = Integer.MIN_VALUE;
			record[2] = Integer.MAX_VALUE;
			return null;
		}
		int value = head.value;
		Node left = head.left;
		Node right = head.right;
		Node lBST = posOrder(left, record);
		int lSize = record[0];
		int lMax = record[1];
		int lMin = record[2];
		Node rBST = posOrder(right, record);
		int rSize = record[0];
		int rMax = record[1];
		int rMin = record[2];
		record[1] = Math.max(value, rMax);
		record[2] = Math.min(value, lMin);
		if(left == lBST && right == rBST && value > lMax && value < rMin){
			record[0] = lSize + rSize + 1;
			return head;
		}
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize?lBST:rBST;
	}
	public static void main(String[] args) {
		Node n1 = new Node(6);
		Node n2 = new Node(1);
		Node n3 = new Node(12);
		Node n4 = new Node(0);
		Node n5 = new Node(3);
		Node n6 = new Node(10);
		Node n7 = new Node(13);
		Node n8 = new Node(4);
		Node n9 = new Node(14);
		Node n10 = new Node(20);
		Node n11 = new Node(16);
		Node n12 = new Node(2);
		Node n13 = new Node(5);
		Node n14 = new Node(11);  
		Node n15 = new Node(15);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n6.left = n8;
		n6.right = n9;
		n7.left = n10;
		n7.right = n11;
		n8.left = n12;
		n8.right = n13;
		n9.left = n14;
		n9.right = n15;
		Main m = new Main();
		System.out.println(m.biggestSubBST(n1).value);;
	}
}
