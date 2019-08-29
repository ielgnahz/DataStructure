package sdu.edu.Structure.ThirdStructure.tarjanQuery;

import java.util.HashMap;

public class DisjoinSets2 {
	
	public HashMap<Node, Node> fatherMap;
	public HashMap<Node, Integer> rankMap;
	
	public DisjoinSets2(){
		this.fatherMap = new HashMap<>();
		this.rankMap = new HashMap<>();
	}
	public void makeSets(Node head){
		fatherMap.clear();
		rankMap.clear();
		preOrder(head);
	}
	public void preOrder(Node head){
		if(head == null){
			return;
		}
		fatherMap.put(head, head);
		rankMap.put(head, 0);
		preOrder(head.left);
		preOrder(head.right);
	}
	
	public Node findFather(Node node){
		Node father = fatherMap.get(node);
		if(father != node){
			father = findFather(father);
		}
		fatherMap.put(node, father);
		return father;
	}
	
	public void union(Node h1,Node h2){
		if(h1 == null || h2 == null){
			return;
		}
		Node f1 = findFather(h1);
		Node f2 = findFather(h2);
		if(f1 != f2){
			int r1 = rankMap.get(h1);
			int r2 = rankMap.get(h2);
			if(r1 > r2){
				fatherMap.put(f2, f1);
			}else if(r1 < r2){
				fatherMap.put(f1, f2);
			}else{
				fatherMap.put(f2, f1);
				rankMap.put(f2, r2+1);
			}
		}
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
		Node n9 = new Node(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n7;
		n5.right = n8;
		n3.right = n6;
		n6.left = n9;
		Query q1 = new Query(n4, n7);
		Query q2 = new Query(n7, n8);
		Query q3 = new Query(n8, n9);
		Query q4 = new Query(n9, n3);
		Query q5 = new Query(n6, n6);
		Query q6 = new Query(null, null);
		Query[] q = {q1,q2,q3,q4,q5,q6};
		Node[] res = new Tarjan1().query(q,n1);
		for (Node n : res) {
			if(n!=null){
				System.out.println(n.value);
			}
		}
		
		
		
		
	}

}
