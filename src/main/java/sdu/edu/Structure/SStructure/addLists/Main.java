package sdu.edu.Structure.SStructure.addLists;

import java.util.Stack;

public class Main {
	public Node addList1(Node head1, Node head2) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		Node cur = head1;
		while (cur != null) {
			stack1.push(cur);
			cur = cur.next;
		}
		cur = head2;
		while (cur != null) {
			stack2.push(cur);
			cur = cur.next;
		}
		int ca = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int a = stack1.isEmpty() ? 0 : stack1.pop().value;
			int b = stack2.isEmpty() ? 0 : stack2.pop().value;
			int real = a + b + ca;
			ca = real / 10;
			Node n = new Node(real % 10);
			n.next = cur;
			cur = n;
		}
		if (ca == 1) {
			Node n = new Node(1);
			n.next = cur;
			cur = n;
		}
		return cur;
	}

	public Node addList2(Node head1, Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		Node cur1 = head1;
		Node cur2 = head2;
		int a = 0;
		int b = 0;
		int n = 0;
		int ca = 0;
		Node cur = null;
		while (cur1 != null || cur2 != null) {
			a = cur1 != null ? cur1.value : 0;
			b = cur2 != null ? cur2.value : 0;
			n = a + b + ca;
			ca = n / 10;
			Node node = new Node(n%10);
			node.next = cur;
			cur = node;
			cur1 = cur1.next!=null?cur1.next:null;
			cur2 = cur2.next!=null?cur2.next:null;
		}
		if(ca == 1){
			Node node = new Node(1);
			node.next = cur;
			cur = node;
		}
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		return cur;
	}

	public Node reverseList(Node head) {
		Node next = null;
		Node pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
