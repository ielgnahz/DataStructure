package sdu.edu.Structure.SecondStructure.addList;

import java.util.Stack;

public class Main {
	public Node addList1(Node head1,Node head2){
		if(head1 == null && head2 == null){
			return null;
		}
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		int a = 0,b = 0,c = 0,n = 0;
		Node node = null;
		Node next = null;
		while(head1!=null){
			stack1.push(head1.next.value);
			head1 = head1.next;
		}
		while(head2!=null){
			stack2.push(head2.next.value);
			head2 = head2.next;
		}
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			a = stack1.isEmpty()?0:stack1.pop();
			b = stack2.isEmpty()?0:stack2.pop();
			n = a + b + c;
			next = node;
			node = new Node(n % 10);
			node.next = next;
			c = n / 10;
		}
		if(c == 1){
			next = node;
			node = new Node(1);
			node.next = next;
		}
		return node;
		
	}
	
	public Node addList2(Node head1,Node head2){
		if(head1 == null && head2 == null){
			return null;
		}
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		int a = 0,b = 0,c = 0,n = 0;
		Node c1 = head1;
		Node c2 = head2;
		Node node = null;
		Node pre = null;
		while(c1 != null || c2 != null){
			a = c1 == null?0:c1.value;
			b = c2 == null?0:c2.value;
			n = a + b + c;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			c = n / 10;
			c1 = c1.next;
			c2 = c2.next;
		}
		if(c == 1){
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		return node;
	}
	public Node reverseList(Node head){
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
