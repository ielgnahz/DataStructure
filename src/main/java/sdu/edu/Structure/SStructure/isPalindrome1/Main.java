package sdu.edu.Structure.SStructure.isPalindrome1;

import java.util.Stack;

public class Main {
	public boolean isPalindrome1(Node head) {
		Node right = head.next;
		Node cur = head;
		Stack<Node> stack = new Stack<>();
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		cur = head;
		while (!stack.isEmpty()) {
			if (cur.value != stack.pop().value) {
				return false;
			}
			cur = cur.next;
		}
		return true;
	}
	public boolean isPalindrome2(Node head){
		Node pre = head;
		Node next = head;
		while(next.next!=null && next.next.next != null){
			pre = pre.next;
			next = next.next.next;
		}
		Node cur = pre.next;
		while(cur!=null){
			next = cur.next;
			cur.next =  pre;
			pre = cur;
			cur = next;
		}
		next = pre;
		cur = head;
		boolean flag = true;
		while(pre != null && cur != null){
			if(pre.value != cur.value){
				flag = true;
				break;
			}
			pre = pre.next;
			cur = cur.next;
		}
		pre = null;
		while(next != null){
			cur = next.next;
			next.next = pre;
			pre = next;
			next = cur;
		}
		return flag;
		
	}
}
