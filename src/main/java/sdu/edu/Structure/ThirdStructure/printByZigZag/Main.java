package sdu.edu.Structure.ThirdStructure.printByZigZag;

import java.util.Deque;
import java.util.LinkedList;


public class Main {
	public void printByZigZag(Node head){
		if(head == null){
			return;
		}
		Node last = head;
		Node nlast = null;
		int level = 1;
		Deque<Node> queue = new LinkedList<>();
		boolean flag = true;
		queue.offerFirst(head);
		printLevelAndOrientation(flag,level++);
		while(!queue.isEmpty()){
			if(flag){
				head = queue.pollFirst();
				System.out.print(" "+head.value);
				if(head.left!= null){
					queue.offerLast(head.left);
					nlast = nlast == null?head.left:nlast;
				}
				
				if(head.right != null){
					queue.offerLast(head.right);
					nlast = nlast == null?head.right:nlast;
				}
				
			}else{

				head = queue.pollLast();
				System.out.print(" "+head.value);
				if(head.right!= null){
					queue.offerFirst(head.right);
					nlast = nlast == null?head.right:nlast;
				}
				
				if(head.left != null){
					queue.offerFirst(head.left);
					nlast = nlast == null?head.left:nlast;
				}
			}
			if(last == head && !queue.isEmpty()){
				flag = !flag;
				printLevelAndOrientation(flag, level++);
				last = nlast;
				nlast = null;
			}
		}
	}
	public void printLevelAndOrientation(boolean flag,int level){
		System.out.print("\nLevel "+level+" : ");
		System.out.print(flag?"from left to right":"from right to left");
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
		new Main().printByZigZag(n1);
	
	}
}
