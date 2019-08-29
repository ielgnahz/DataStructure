package sdu.edu.Structure.TestStructure.Link;

import java.util.Stack;

public class Main {
	public Node removeLastKNode(Node head, int k) {
		Node pre = head;
		while (pre != null) {
			k--;
			pre = pre.next;
		}
		pre = head;
		if (k == 0) {
			head = head.next;
		}
		if (k < 0) {
			pre = head;
			while (k++ != 0) {
				pre = pre.next;
			}
			pre.next = pre.next.next;
		}

		return head;
	}

	public Node removeMidNode(Node head) {
		Node pre = head;
		Node right = head.next.next;
		while (right.next != null && right.next.next != null) {
			pre = pre.next;
			right = right.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}

	public Node removeKNode(Node head, int a, int b) {
		int n = 0;
		Node cur = head;
		while (cur != null) {
			n++;
		}
		double k = Math.ceil((double) a * n / (double) b);
		cur = head;
		if (k == 1) {
			head = head.next;
		}
		while (--k != 1) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return head;
	}

	public Node reverseList(Node head) {
		Node pre = null;
		Node cur = head;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public Node reverPart(Node head, int from, int to) {
		Node fPre = null;
		Node tPos = null;
		Node cur = head;
		int k = 1;
		while (cur != null) {
			fPre = from == k + 1 ? cur : fPre;
			tPos = to == k - 1 ? cur : tPos;
			cur = cur.next;
			k++;
		}
		Node pre = fPre == null ? head : fPre.next;
		cur = pre.next;
		Node next = null;
		pre.next = tPos;
		while (cur != tPos) {
			next = cur.next;
			cur.next = pre;
			pre = cur.next;
			cur = next;
		}
		if (fPre != null) {
			fPre.next = pre;
			return head;
		}
		return pre;
	}

	public Node josephusKill(Node head, int m) {
		Node cur = head;
		int tmp = 0;
		while (cur != null) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, m);

		while (--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}

	public int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		} else {
			return (getLive(i - 1, m) + m - 1) % i + 1;
		}
	}

	public Node listPartition(Node head, int pivot) {
		Node cur = head;
		int tmp = 0;
		while (cur != null) {
			tmp++;
		}
		Node[] arr = new Node[tmp];
		cur = head;
		int i = 0;
		while (cur != null) {
			arr[i++] = cur;
		}
		int small = -1;
		int big = arr.length;
		int index = 0;
		while (index < arr.length) {
			if (arr[index].value < pivot) {
				swap(arr, ++small, index++);
			} else if (arr[index].value > pivot) {
				swap(arr, --big, index);
			} else {
				index++;
			}
		}
		for (int k = 0; k < arr.length - 1; k++) {
			arr[k].next = arr[k + 1];
		}
		arr[arr.length - 1] = null;
		return arr[0];
	}

	public void swap(Node[] arr, int a, int b) {
		Node tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public Node reverseKNode(Node head, int k) {
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		Node pre = null;
		Node next = null;
		Node newHead = null;
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == k) {
				pre = resign(pre, next, stack);
				newHead = pre == null ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}

	public Node resign(Node left, Node right, Stack<Node> stack) {
		Node cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		Node next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}

	public Node reverseKNode1(Node head, int k) {
		Node cur = head;
		Node pre = null;
		Node next = null;
		int m = 0;
		Node start = null;
		while (cur != null) {
			next = cur.next;
			m++;
			if (m == k) {
				start = pre == null ? head : pre.next;
				resign1(pre, start, cur, next);
				head = pre == null?cur:head;
				pre = start;
				m = 0;
			}
			cur = next;
		}
		return head;
	}

	public void resign1(Node left, Node start, Node end, Node right) {
		Node cur = start.next;
		Node pre = cur;
		Node next = null;
		while(cur != right){
			next  =cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(left != null){
			left.next = end;
		}
		start.next = right;
	}
	
	public Node selectionSort(Node head){
		Node cur = head.next;
		Node smallPre = null;
		Node small = head;
		Node tail = null;
		while(cur != null){
			smallPre = getSmallestPreNode(cur);
			small = cur;
			if(smallPre != null){
				small = smallPre;
				smallPre.next = small.next;
			}
			cur = cur == small?cur.next:cur;
			if(tail == null){
				tail = small;
				head = small;
			}else{
				tail.next = small;
				tail = tail.next;
				}
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
			cur = cur.next;
			pre = pre.next;
		}
		return smallPre;
	}
	public void relocate(Node head){
		if(head == null || head.next == null){
			return;
		}
		Node mid = head;
		Node right = head.next;
		while(right.next != null && right.next.next != null){
			mid = mid.next;
			right = right.next;
		}
		right = mid.next;
		mid.next = null;
		merge(head,right);
	}
	public void merge(Node left,Node right){
		Node next = null;
		while(left.next != null){
			next = right.next;
			left.next = right;
			right.next = left.next;
			left = right.next;
			right = next;
		}
		left.next = right;
	}

	
}
