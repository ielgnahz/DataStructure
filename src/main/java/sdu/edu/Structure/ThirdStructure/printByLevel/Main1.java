package sdu.edu.Structure.ThirdStructure.printByLevel;

import java.util.LinkedList;
import java.util.Queue;

public class Main1 {
	public void printByLevel(Node head){
		if(head == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		Node last = head;
		Node nlast = head;
		int level = 1;
		System.out.print("Level "+ (level++)+" : ");
		while(!queue.isEmpty()){
			head = queue.poll();
			System.out.println(head.value+" ");
			if(head.left != null){
				queue.offer(head.left);
				nlast = head.left;
			}
			if(head.right != null){
				queue.offer(head.right);
				nlast = head.right;
			}
			if(last == head && !queue.isEmpty()){
				last = nlast;
				System.out.print("\nLevel "+(level++)+" : ");
				
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
