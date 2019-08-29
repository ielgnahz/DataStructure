package sdu.edu.Structure.ThirdStructure.printByZigZag;

import java.util.Deque;
import java.util.LinkedList;


public class Main1 {
	public void printByZigZag(Node head) {
		if(head == null){
			return;
		}
		boolean flag = true;
		Node last = head;
		Node nlast = null;
		Deque<Node> queue = new LinkedList<>();
		queue.addLast(head);;
		int level = 1;
		printLevel(flag,level++);
		while(!queue.isEmpty()){
			if(flag){
				head = queue.pollLast();
				if(head.left != null){
					queue.addFirst(head.left);
					nlast = nlast == null?head.left:nlast;
				}
				if(head.right != null){
					queue.addFirst(head.right);
					nlast = nlast == null?head.right:nlast;
				}
			}else{
				head = queue.pollFirst();
				if(head.right != null){
					queue.addLast(head.right);
					nlast = nlast == null?head.right:nlast;
				}
				if(head.left != null){
					queue.addLast(head.left);
					nlast = nlast == null?head.left:nlast;
				}
			}
			System.out.print(head.value+" ");
			if(head == last && !queue.isEmpty()){
				System.out.println();
				last = nlast;
				nlast = null;
				flag = !flag;
				printLevel(flag,level++);
			}
		}
	}
	public void printLevel(boolean flag,int level){
		System.out.print("Levle "+level);
		if(flag){
			System.out.print(" from left to right: ");
		}else{
			System.out.print(" from right to left: ");
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
		new Main1().printByZigZag(n1);

	}
}
