package sdu.edu.Structure.ThirdStructure.preinposOrderRecur;

import java.util.Stack;

public class Main {
	public void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.println(head.value + " ");
		inOrderRecur(head.right);
	}

	public void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.value + " ");
	}

	public void perOrderUnRecur(Node head) {
		if(head == null){
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while(!stack.isEmpty()){
			head = stack.pop();
			System.out.println(head.value);
			if(head.right != null){
				stack.push(head.right);
			}
			if(head.left != null){
				stack.push(head.left);
			}
		}
	}
	
	public void inOrderUnRecur(Node head){
		Stack<Node> stack = new Stack<>();
		while(!stack.isEmpty() || head != null){
			if(head != null){
				stack.push(head);
				head = head.left;
			}else{
				head = stack.pop();
				System.out.println(head.value);
				head = head.right;
			}
		}
	}
	
	public void posOrderUnRecur1(Node head){
		if(head != null){
			Stack<Node> stack1 = new Stack<>();
			Stack<Node> stack2 = new Stack<>();
			stack1.push(head);
			while(!stack1.isEmpty()){
				head = stack1.pop();
				if(head.left != null){
					stack1.push(head.left);
				}
				if(head.right != null){
					stack1.push(head.right);
				}
				stack2.push(head);
			}
			while(!stack2.isEmpty()){
				System.out.println(stack2.pop().value+" ");
			}
		}
	}
	
	public void posOrderUnRecur2(Node head){
		if(head == null){
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node h  = head;
		Node c = null;
		stack.push(head);
		while(!stack.isEmpty()){
			c = stack.peek();
			if(c.left != null && c.left != h && c.right != h){
				stack.push(c.left);
			}else if(c.right != null && c.right != h){
				stack.push(c.right);
			}else{
				h = stack.pop();
				System.out.println(h.value);
			}
		}
	}
}
