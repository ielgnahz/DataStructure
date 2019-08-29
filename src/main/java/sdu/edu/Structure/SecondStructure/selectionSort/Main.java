package sdu.edu.Structure.SecondStructure.selectionSort;

public class Main {
	public Node selectionSort(Node head){
		Node small = null;
		Node smallPre = null;
		Node cur = head;
		Node tail = null;
		while(cur != null){
			small = cur;
			smallPre = getSmallestPreNode(cur);
			if(smallPre != null){
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur == small?cur.next:cur;
			if(tail == null){
				head = small;
			}else{
				tail.next = small;
			}
			tail = small;
		}
		tail.next = null;
		return head;
		
	}
	public Node getSmallestPreNode(Node head){
		Node cur = head.next;
		Node small = head;
		Node smallPre = null;
		Node pre = head;
		while(cur != null){
			if(cur.value < small.value){
				smallPre = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallPre;
	}
}
