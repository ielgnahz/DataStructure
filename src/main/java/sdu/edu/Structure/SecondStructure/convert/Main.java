package sdu.edu.Structure.SecondStructure.convert;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public Node convert1(Node head){
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(queue, head);
		Node pre = queue.poll();
		head = pre;
		Node cur = null;
		while(!queue.isEmpty()){
			cur = queue.poll();
			cur.left = pre;
			pre.right = cur;
			pre = cur;
		}
		pre.right = null;
		return head;
		
		
	}
	public void inOrderToQueue(Queue<Node> queue,Node head){
		if(head == null){
			return;
		}
		inOrderToQueue(queue, head.left);
		queue.offer(head);
		inOrderToQueue(queue, head.right);
	}
	public Node convert2(Node head){
		Node right = process(head);
		head = right.right;
		right.right = null;
		return head;
		
	}
	public Node process(Node head){
		if(head == null){
			return null;
		}
		Node leftE = process(head.left);
		Node rightE = process(head.right);
		Node leftS = leftE == null?null:leftE.right;
		Node rightS = rightE == null?null:rightE.right;
		if(leftE != null && rightE != null){
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		}else if(leftE != null){
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		}else if(rightE != null){
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		}else{
			head.right = head;
			return head;
		}
		
		
	}
}
