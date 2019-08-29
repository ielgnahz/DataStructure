package sdu.edu.Structure.ThirdStructure.printByLevel;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public void printByLevel(Node head){
		if(head == null){
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		int level = 1;
		int last = head.value;
		int nlast = 0;
		Node cur = null;
		System.out.print("Level "+(level++)+" :");
		while(!queue.isEmpty()){
			cur = queue.poll();
			System.out.print(" "+cur.value);
			if(cur.left != null){
				queue.offer(cur.left);
				nlast = cur.left.value;
			}
			if(cur.right != null){
				queue.offer(cur.right);
				nlast = cur.right.value;
			}
			if(cur.value == last && !queue.isEmpty()){    
				System.out.print("\nLevel "+ (level++)+" :");
				last = nlast;
			}
		}
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
		n3.left = n5;
		n3.right = n6;
		n5.left = n7;
		n5.right = n8;
		new Main().printByLevel(n1);
	}
}
