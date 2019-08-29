package sdu.edu.Structure.SStructure.removeLastKthNode;

public class Main {
	public Node removeLastKthNode(Node head, int lastKth) {
		Node curNode = head;
		while (curNode != null) {
			lastKth--;
			curNode = curNode.next;
		}
		if (lastKth == 0) {
			head = head.next;
		} else if (lastKth < 0) {
			curNode = head;
			while (++lastKth != 0) {
				curNode = curNode.next;
			}
			curNode.next = curNode.next.next;
		}
		return head;
	}

	public DoubleNode removeLastKthDoubleNode(DoubleNode head, int lastKth) {
		DoubleNode curNode = head;
		while(curNode != null){
			curNode = curNode.next;
		}
		if(lastKth == 0){
			head = head.next;
			head.last = null;
		}else if(lastKth < 0){
			curNode = head;
			while(++lastKth != 0){
				curNode = curNode.next;
			}
			curNode.next = curNode.next.next;
			if(curNode.next != null){
				curNode.next.last = curNode;
			}
		}
		return head;
		
	}
}
