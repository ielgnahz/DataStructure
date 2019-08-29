package sdu.edu.Structure.SStructure.removeMidNode;

public class Main {
	public Node removeMidNode(Node head){
		
		
		Node pre = head;
		Node cur = head.next.next;
		if(cur == null){
			return head.next;
		}
		while(cur.next != null && cur.next.next != null){
			pre = pre.next;
			cur = cur.next.next;
		}
		pre = pre.next.next;
		return head;
	}
	public Node removeabNode(Node head,int a,int b){
		Node cur = head;
		int n = 0;
		while(cur != null){
			n++;
			cur = cur.next;
		}
		int real = (int) Math.ceil((double)a * n/b);
		if(n == 1){
			return head.next;
		}
		cur = head;
		while(--real != 1){
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return head;
	}
}	
