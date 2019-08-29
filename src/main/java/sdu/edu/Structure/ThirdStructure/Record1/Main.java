package sdu.edu.Structure.ThirdStructure.Record1;

import java.util.HashMap;


public class Main {
	public HashMap<Node, Node> map = new HashMap<>();

	public Main(Node head) {
		if (head != null) {
			map.put(head, null);
		}
		setMap(head);
	}

	public void setMap(Node head) {
		if(head == null){
			return;
		}
		if (head.left != null) {
			map.put(head.left, head);
		}
		if (head.right != null) {
			map.put(head.right, head);
		}
		setMap(head.left);
		setMap(head.right);
	}

	public Node query(Node o1, Node o2) {
		HashMap<Node, Node> m2 = new HashMap<>();
		while (map.containsKey(o1)) {
			m2.put(o1, map.get(o1));
			o1 = map.get(o1);
		}
		while(!map.containsKey(o2)){
				o2 = map.get(o2);
		}
		return o2;
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
		Node n = new Main(n1).query(n6, n8);
		System.out.println(n.value);
	}
}
