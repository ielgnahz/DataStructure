package sdu.edu.Structure.TestStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public Node convert1(Node head) {
		Queue<Node> que = new LinkedList<Node>();
		inOrderToQueue(head, que);
		head = que.poll();
		Node pre = head;
		Node cur = null;
		while (!que.isEmpty()) {
			cur = que.poll();
			cur.left = pre;
			pre.right = cur;
			pre = cur;
		}
		cur.right = null;
		return head;
	}

	public Node convert2(Node head) {
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
		Node leftS = leftE != null ? leftE.right : null;
		Node rightS = rightE != null ? rightE.right : null;
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.right = rightS;
			head.left = leftE;
			rightS.left = head;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			head.right = rightS;
			rightE.right = head;
			rightS.left = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}

	}

	public void inOrderToQueue(Node head, Queue<Node> que) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, que);
		que.offer(head);
		inOrderToQueue(head.right, que);
	}

	public int maxDistance(Node head) {
		if (head == null) {
			return 0;
		}
		int[] record = new int[1];
		return posOrder(head, record);
	}

	public int posOrder(Node head, int[] record) {
		if (head == null) {
			record[0] = 1;
			return 0;
		}
		int lMax = posOrder(head.left, record);
		int maxFromLeft = record[0];
		int rMax = posOrder(head.right, record);
		int maxFromRight = record[0];
		int curNodeLen = maxFromLeft + maxFromRight + 1;
		record[0] = Math.max(maxFromRight, maxFromLeft)+1;
		int max = Math.max(Math.max(lMax, rMax), curNodeLen);
		return max;
	}
	public int nodeNum(Node head){
		if(head == null){
			return 0;
		}
		return bs(head,1,mostLevel(head,1));
	}
	public int bs(Node head,int l,int h){
		if(l == h){
			return 1;
		}
		if(mostLevel(head.right, l+1) == h){
			return 1<<(h-l) + bs(head.right, l+1, h);
		}else{
			return 1<<(h-l-1) + bs(head.left, l+1, h);
		}
	}
	public int mostLevel(Node head,int i){
		while(head.left != null){
			head = head.left;
			i++;
		}
		return i;
	}
}
