package sdu.edu.Structure.ThirdStructure.lowestAncestor;

public class Main {
	public Node lowestAncestor(Node head,Node o1,Node o2){
		if(head == null || head == o1 || head == o2 ){
			return head;
		}
		Node h1 = lowestAncestor(head.left, o1, o2);
		Node h2 = lowestAncestor(head.right, o1, o2);
		if(h1 != null && h2 != null){
			return head;
		}
		return h1 == null?h2:h1;
	}
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n7.left = n8;
		Node n = new Main().lowestAncestor(n1, n6, n8);
		System.out.println(n.value);
	}
}
