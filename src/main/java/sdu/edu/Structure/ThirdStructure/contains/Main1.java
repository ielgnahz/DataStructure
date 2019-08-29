package sdu.edu.Structure.ThirdStructure.contains;

public class Main1 {
	public boolean contains(Node t1, Node t2) {
		if (t1 == null || t2 == null) {
			return false;
		}
		return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
	}

	public boolean check(Node t1, Node t2) {
		if (t2 == null) {
			return true;
		}
		if (t1 == null || t1.value != t2.value) {
			return false;
		}
		return check(t1.left, t2.left) && check(t1.right, t2.right);
	}
}
