package sdu.edu.Structure.SStructure.listPartition;

public class Main {
	public Node listPartition1(Node head, int pivot) {
		Node cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nArr = new Node[i];
		cur = head;
		for (int j = 0; j < nArr.length; j++) {
			nArr[j] = cur;
			cur = cur.next;
		}
		int index = 0, small = -1, big = nArr.length;
		while (index != big) {
			if (nArr[index].value < pivot) {
				swap(nArr, ++small, index++);
			} else if (nArr[index].value == pivot) {
				index++;
			} else {
				swap(nArr, index, --big);
			}
		}
		head = nArr[0];
		for (int j = 0; j < nArr.length - 1; j++) {
			nArr[i].next = nArr[i + 1];
		}
		nArr[nArr.length - 1].next = null;
		return head;
	}

	public Node listPartition(Node head, int pivot) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = sT.next;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = eT.next;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = bT.next;
				}
			}
			head = next;
		}
		if (sH != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		if (eT.next != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH == null ? bH : eH;

	}

	public void swap(Node[] nArr, int from, int to) {
		Node tmp = nArr[from];
		nArr[from] = nArr[to];
		nArr[to] = tmp;
	}

}
