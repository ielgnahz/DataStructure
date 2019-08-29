package sdu.edu.Structure.SecondStructure.reverseKNodes;

import java.util.Stack;

public class Main1 {
	public Node reverseKNodes1(Node head, int K) {
		if(head == null){
			return null;
		}
		Node cur = head;
		Node next = null;
		Node pre = null;
		Node start = null;
		int count = 0;
		while(cur != null){
			next = cur.next;
			count++;
			if(count == K){
				start = pre == null?head:pre.next;
				head = pre == null?cur:head;
				resign1(pre, start, cur, next);
				pre = start;
			}
			cur = next;
		}
		return head;
	}
	
	public void resign1(Node left,Node start,Node end,Node right){
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while(cur != right){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(left != null){
			left.next = pre;
		}
		start.next = right;
	}
	public Node reverseKNodes(Node head, int K) {
		if(head == null){
			return null;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		Node next = null;
		Node pre = null;
		while(cur != null){
			stack.push(cur);
			if(stack.size() == K){
				pre = resign(pre, next, stack);
				head = pre == null?cur:head;
			}
			cur = next;
		}
		return head;
	}

	public Node resign(Node left, Node right, Stack<Node> stack) {
		Node pre = stack.pop();
		if(left != null){
			left.next = pre;
		}
		Node cur = null;
		while(!stack.isEmpty()){
			cur = stack.pop();
			cur.next = pre;
			pre = cur;
		}
		cur.next = right;
		return cur;
	}
}
