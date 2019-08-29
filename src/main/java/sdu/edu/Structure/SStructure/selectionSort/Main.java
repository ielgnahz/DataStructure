package sdu.edu.Structure.SStructure.selectionSort;

public class Main {
	public Node selectionSort(Node head){
		if(head == null){
			return head;
		}
		Node cur = head;
		Node small = null;
		Node smallPre = null;
		Node tail = null;
		while(cur != null){
			small = cur;
			smallPre = getSmallestPreNode(cur);
			if(smallPre != null){
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur == small?cur.next:cur;
			if(tail != null){
				tail.next = small;
			}else{
				head = small;
			}
			tail = small;
		}
		return head;
	}
	public Node getSmallestPreNode(Node head){
		Node cur = head.next;
		Node pre = head;
		Node small = head;
		Node smallPre = null;
		while(cur != null){
			if(cur.value < small.value){
				small = cur;
				smallPre = pre;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallPre;
	}
}
