package sdu.edu.Structure.SecondStructure.removeMidNode;
//删除单链表的中间结点和a/b处的节点
public class Main {
	public Node removeMidNode(Node head){
		if(head == null || head.next == null){
			return null;
		}
		if(head.next.next == null){
			return head.next;
		}
		Node preNode = head;
		Node curNode = head.next.next;
		while(curNode.next != null && curNode.next.next != null){
			curNode = curNode.next.next;
			preNode = preNode.next;
		}
		preNode.next = preNode.next.next;
		return head;
	}
	public Node removeByRatio(Node head,int a,int b){
		if(a < 1 || a > b){
			return head;
		}
		int n = 0;
		Node curNode = head;
		while(curNode != null){
			n++;
			curNode = curNode.next;
		}
		n = (int)Math.ceil((double)(a * n) / (double)b);
		if(n == 1){
			head = head.next;
		}
		if(n > 1){
			curNode = head;
			while(--n != 1){
				curNode = curNode.next;
			}
			curNode.next = curNode.next.next;
		}
		return head;
	}
}
