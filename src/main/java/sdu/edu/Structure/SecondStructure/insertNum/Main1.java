package sdu.edu.Structure.SecondStructure.insertNum;

public class Main1 {
	public Node insertNum(Node head,int num){
		Node node = new Node(num);
		if(head == null){
			return node;
		}
		Node cur = head.next;
		Node pre = head;
		while(cur != head){
			if(num > pre.value && num < cur.value){
				break;
			}
			pre = pre.next;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value > num?node:head;
	}
}
