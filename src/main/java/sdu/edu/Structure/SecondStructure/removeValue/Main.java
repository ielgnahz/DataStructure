package sdu.edu.Structure.SecondStructure.removeValue;

import java.util.Stack;

public class Main {
	public Node removeValue1(Node head, int value) {
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while (cur != null) {
			if (cur.value != value) {
				stack.push(cur);
			}
			cur = cur.next;
		}
		head = null;
		while (!stack.isEmpty()) {
			stack.peek().next = head;
			head = stack.pop();
		}
		return head;
	}

	public Node removeValue2(Node head, int value) {
		while (head != null) {
			if (head.value != value) {
				break;
			}
			head = head.next;
		}
		Node pre = head;
		Node cur = head.next;
		while(cur != null){
			if(cur.value == value){
				pre.next = cur.next;
			}else{
				pre = pre.next;
			}
			cur = cur.next;
		}
		return head;
	}
}
