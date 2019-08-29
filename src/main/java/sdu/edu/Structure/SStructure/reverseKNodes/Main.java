package sdu.edu.Structure.SStructure.reverseKNodes;

import java.util.Stack;

public class Main {
	public Node reverseKNodes1(Node head,int K){
		if(K < 2){
			return head;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		Node newHead = head;
		Node pre = null;
		Node next = null;
		while(cur != null){
			next = cur.next;
			stack.push(cur);
			if(stack.size() == K){
				pre = resign1(pre,stack,next);
				newHead = newHead == head?cur:head;
			}
			cur = next;
		}
		return newHead;
	}
	public Node resign1(Node left,Stack<Node> stack,Node right){
		Node cur = stack.pop();
		if(left != null){
			left.next = cur;
		}
		Node next = null;
		while(!stack.isEmpty()){
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}
	
	public Node reverseKNodes2(Node head,int K){
		if(K > 2){
			return head;
		}
		Node cur = head;
		Node pre = null;
		Node next = null;
		Node start = null;
		int n =0;
		while(cur != null){
			n++;
			next = cur.next;
			if(n == K){
				start = pre == null?head:pre.next;
				head = pre == null?cur:head;
				resign2(pre,start,cur,next);
				pre = start;
				n = 0;
			}
			cur = next;
		}
		return head;
	}
	public void resign2(Node left,Node start,Node end,Node right){
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
			left.next = end;
		}
		start.next = right;
		
	}
}
