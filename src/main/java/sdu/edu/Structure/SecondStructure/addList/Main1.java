package sdu.edu.Structure.SecondStructure.addList;

import java.util.Stack;

public class Main1 {
	public Node addList(Node h1,Node h2){
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		while(h1 != null){
			s1.push(h1);
			h1 = h1.next;
		}
		while(h2 != null){
			s2.push(h2);
			h2 = h2.next;
		}
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		int ca = 0;
		Node cur = null;
		Node pre = null;
		while(!s1.isEmpty() || !s2.isEmpty()){
			n1 = s1.isEmpty()?0:s1.pop().value;
			n2 = s2.isEmpty()?0:s2.pop().value;
			n = n1 + n2 + ca;
			pre = cur;
			cur = new Node(n % 10);
			cur.next = pre;
			ca = n / 10;
		}
		if(ca == 1){
			pre = cur;
			cur = new Node(ca);
			cur.next = pre;
		}
		return cur;
	}
	
	public Node addList1(Node h1,Node h2){
		h1 = reverse(h1);
		h2 = reverse(h2);
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		int ca = 0;
		Node c1 = h1;
		Node c2 = h2;
		Node node = null;
		Node pre = null;
		while(c1 != null || c2 != null){
			n1 = c1 == null?0:c1.value;
			n2 = c2 == null?0:c2.value;
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			c1 = c1 == null?null:c1.next;
			c2 = c2 == null?null:c2.next;
		}
		if(ca == 1){
			pre = node;
			node = new Node(ca);
			node.next = pre;
		}
		reverse(h1);
		reverse(h2);
		return node;
	}
	public Node reverse(Node head){
		Node next = null;
		Node pre = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
