package sdu.edu.Structure.SecondStructure.isPalindromel;

import java.util.Stack;

public class Main1 {
	public boolean isPalindromel(Node head){
		if(head == null){
			return false;
		}
		Node cur = head.next;
		Node right = head;
		while(right.next != null && right.next.next != null){
			right = right.next.next;
			cur = cur.next;
		}
		Stack<Node> stack = new Stack<>();
		while(cur != null){
			stack.push(cur);
			cur = cur.next;
		}
		cur = head;
		while(!stack.isEmpty()){
			if(cur.value != stack.pop().value){
				return false;
			}
			cur = cur.next;
		}
		return true;
	}
	public boolean isPalindromel1(Node head){
		if(head == null){
			return false;
		}
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null){
			n1 = n1.next;
			n2 = n2.next.next;
		}
		Node n3 = null;
		n2 = n1.next;
		while(n2 != null){
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;
		n2 = head;
		boolean flag = true;
		while(n1 != null && n2 != null){
			if(n1.value != n2.value){
				flag = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		n1 = null;
		while(n3 != null){
			n2 = n3.next;
			n3.next = n1;
			n1 = n3;
			n3 = n2;
		}
		return flag;
	}
}
