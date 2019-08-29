package sdu.edu.Structure.SecondStructure.josephusKill1;

public class Main1 {
	public Node josephusKill1(Node head, int m) {
		if (head == null) {
			return null;
		}
		Node cur = head.next;
		int num = 1;
		while (cur != head) {
			num++;
			cur = cur.next;
		}
		num = getLive(num, m);
		while (--num != 0) {
			cur = cur.next;
		}
		cur.next = cur;
		return cur;
	}

	public int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getLive(i - 1, m) + m - 1) % i + 1;
	}
}
