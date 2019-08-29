package sdu.edu.Structure.ThirdStructure.Record1;

import java.util.HashMap;

public class Main1 {
	HashMap<Node, Node> map;
	public Main1(Node head){
		map = new HashMap<>();
		if(head != null){
			map.put(head, null);
		}
		setMap(head);
	}
	public void setMap(Node head){
		if(head == null){
			return;
		}
		if(head.left != null){
			map.put(head.left, head);
		}
		if(head.right != null){
			map.put(head.right, head);
		}
		setMap(head.left);
		setMap(head.right);
	}
	public Node query(Node o1,Node o2){
		HashMap<Node, Node> m2 = new HashMap<>();
		Node head = o1;
		while(head!=null){
			head = map.get(o1);
			m2.put(o1, head);
		}
		while(!m2.containsKey(o2)){
			o2 = map.get(o2);
		}
		return o2;
	}
}
