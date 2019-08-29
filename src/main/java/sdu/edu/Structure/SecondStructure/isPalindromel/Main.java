package sdu.edu.Structure.SecondStructure.isPalindromel;

import java.util.Stack;

public class Main {
	public boolean isPalindrome1(Node head){
		if(head == null){
			return false;
		}
		Stack<Node> stack = new Stack<>();
		Node curNode = head;
		while(curNode != null){
			stack.push(curNode);
			curNode = curNode.next;
		}
		while(head != null){
			if(stack.pop().value != head.value){
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public boolean isPalindrome2(Node head){
		if(head == null || head.next == null){
			return false;
		}
		Node right = head.next;
		Node curNode = head;
		while(curNode.next != null && curNode.next.next != null){
			right = right.next;
			curNode = curNode.next.next;
		}
		Stack<Node> stack = new Stack<>();
		while(right != null){
			stack.push(right);
			right = right.next;
		}
		while(!stack.isEmpty()){
			if(stack.pop().value != head.value){
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public boolean isPalindrome3(Node head){
		if(head == null){
			return false;
		}
		Node n1 = head;
		Node n2 = head;
		while(n1.next != null && n2.next.next != null ){
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while(n2 != null){
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;
		n2 = head;
		boolean flag =true;
		while(n1 != null && n2 != null){
			if(n1.value != n2.value){
				flag = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		n2 = n3.next;
		n3.next = null;
		while(n2 != null){
			n1 = n2.next;
			n2.next = n3;
			n3 = n2;
			n2 = n1;
		}
		return flag;
		
	} 
}
