package sdu.edu.Structure.ThirdStructure.Record2;

import java.util.HashMap;


public class Main {
	private HashMap<Node, HashMap<Node, Node>> map;
	public Main(Node head){
		map = new HashMap<>();
		initMap(head);
		setMap(head);
	}
	private void initMap(Node head){
		if(head == null){
			return;
		}
		map.put(head, new HashMap());
		initMap(head.left);
		initMap(head.right);
	}
	private void setMap(Node head){
		if(head == null){
			return;
		}
		headRecord(head.left,head);
		headRecord(head.right,head);
		printLeft(head.left,head.right,head);
		setMap(head.left);
		setMap(head.right);
	}
	private void headRecord(Node n,Node h){
		if(n == null){
			return;
		}
		map.get(n).put(h, h);
		headRecord(n.left, h);;
		headRecord(n.right, h);
	}
	public void printLeft(Node l,Node r,Node h){
		if(l == null){
			return;
		}
		printRight(l,r,h);
		printLeft(l.left, r, h);
		printLeft(l.right, r, h);
	}
	public void printRight(Node l,Node r,Node h){
		if(r == null){
			return;
		}
		map.get(l).put(r, h);
		printRight(l, r.left, h);
		printRight(l, r.right, h);
	}
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n7.left = n8;
		HashMap<Node, HashMap<Node, Node>> map = new Main(n1).map;
		System.out.println(map.get(n6).get(n8).value);
	}
	
}
