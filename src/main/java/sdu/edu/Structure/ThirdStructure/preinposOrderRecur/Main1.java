package sdu.edu.Structure.ThirdStructure.preinposOrderRecur;

import java.util.Stack;

public class Main1 {
	public void preOrderUnRecur(Node head) {
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

	public void inOrderUnRecur(Node head) {
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

	public void posOrderUnRecur(Node head) {
		if(head == null){
			return;
		}
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(head);
		while(!s1.isEmpty()){
			head = s1.pop();
			if(head.left != null){
				s1.push(head.left);
			}
			if(head.right != null){
				s1.push(head.right);
			}
			s2.push(head);
		}
		while(!s2.isEmpty()){
			System.out.println(s2.pop().value);
		}
	}

	public void posOrderUnRecur2(Node head){
		if(head != null){
			return;
		}
		Node h = head;
		Node c = null;
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while(stack.isEmpty()){
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
