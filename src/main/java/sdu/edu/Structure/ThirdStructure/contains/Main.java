package sdu.edu.Structure.ThirdStructure.contains;

public class Main {
	public boolean contains(Node t1,Node t2){
		return check(t1,t2) || contains(t1.left,t2) || contains(t1.right,t2);
	}
	public boolean check(Node h,Node n){
		if(n == null){
			return true;
		}
		if(h == null || h.value != n.value){
			return false;
		}
		return check(h.left,n.left) && check(h.right,n.right);
		
	}
}
