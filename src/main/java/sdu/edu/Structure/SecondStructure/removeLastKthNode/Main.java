package sdu.edu.Structure.SecondStructure.removeLastKthNode;
//在单链表和双链表中删除倒数第K个节点
public class Main {
		public Node removeLastKthNode(Node head, int lastKth){
			if(head == null || lastKth < 0){
				return null;
			}
			Node curNode = head;
			while(curNode != null){
				lastKth--;
				curNode = curNode.next;
			}
			if(lastKth == 0){
				head = head.next;
			}else if(lastKth < 0){
				curNode = head;
				while(lastKth != 0){
					lastKth++;
					curNode = curNode.next;
				}
				curNode.next = curNode.next.next;
			}
			return head;
		}
		public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
			if(head == null || lastKth < 0){
				return null;
			}
			DoubleNode curNode = head;
			while(curNode != null){
				lastKth --;
				curNode = curNode.next;
			}
			if(lastKth == 0){
				head = head.next;
			}else if(lastKth < 0){
				curNode = head;
				while(lastKth != 0){
					lastKth ++;
					curNode = curNode.next;
				}
				DoubleNode newNode = curNode.next.next;
				curNode.next = newNode;
				if(newNode!=null){
					newNode.last = curNode;
				}
			}
			return head;
		}
}
