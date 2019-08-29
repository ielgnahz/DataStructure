package sdu.edu.Structure.ThirdStructure.tarjanQuery;

import java.util.HashMap;

public class DisjoinSets {
	private HashMap<Node, Node> fatherMap;
	private HashMap<Node, Integer> rankMap;
	public DisjoinSets(){
		fatherMap = new HashMap<>();
		rankMap = new HashMap<>();
	}
	public void makeSets(Node head){
		fatherMap.clear();
		rankMap.clear();
		perOrder(head);
	}
	public void perOrder(Node head){
		if(head == null){
			return;
		}
		fatherMap.put(head, head);
		rankMap.put(head, 0);
		perOrder(head.left);
		perOrder(head.right);
	}
	public Node findfather(Node head){
		Node father = fatherMap.get(head);
		if(father != head){
			father = findfather(father);
		}
		fatherMap.put(head, father);
		return father;
	}
	public void union(Node a,Node b){
		if(a == null || b == null){
			return;
		}
		Node aFather = findfather(a);
		Node bFather = findfather(b);
		if(aFather != bFather){
			int aRank = rankMap.get(aFather);
			int bRank = rankMap.get(bFather);
			if(aRank > bRank){
				fatherMap.put(bFather, aFather);
			}else if(aRank < bRank){
				fatherMap.put(aFather, bFather);
			}else{
				fatherMap.put(bFather, aFather);
				rankMap.put(aFather, aRank + 1);
			}
			
		}
	}
}
