package sdu.edu.Structure.SecondStructure.convert;

import java.util.LinkedList;
import java.util.Queue;

public class Main1 {
	public Node convert1(Node head) {
		if (head == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<Node>();
		inOrderQueue(head, queue);
		Node pre = queue.poll();
		pre.left = null;
		head = pre;
		Node cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			cur.left = pre;
			pre.right = cur;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	public void inOrderQueue(Node node, Queue<Node> queue) {
		if (node == null) {
			return;
		}
		inOrderQueue(node.left, queue);
		queue.offer(node);
		inOrderQueue(node.right, queue);
	}

	public Node convert2(Node head) {
		if (head == null) {
			return null;
		}
		Node last = process(head);
		head = last.right;
		last.right = null;
		return head;
	}

	public Node process(Node head) {
		if (head == null) {
			return null;
		}
		Node leftE = process(head.left);
		Node rightE = process(head.right);
		Node leftS = leftE == null?null:leftE.right;
		Node rightS = rightE == null?null:rightE.right;
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.right = rightS;
			head.left = leftE;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		}else if(leftE != null){
			leftE.right = head;
			head.right = leftS;
			head.left = leftE;
			return head;
		}else if(rightE != null){
			head.right = rightS;
			rightE.right = head;
			rightS.left = head;
			return rightE;
		}else{
			head.right = head;
			return head;
		}

	}

}
