package sdu.edu.Structure.ThirdStructure.tarjanQuery;

import java.util.HashMap;
import java.util.LinkedList;

public class Tarjan1 {

	public HashMap<Node, LinkedList<Node>> queryMap;
	public HashMap<Node, LinkedList<Integer>> indexMap;
	public DisjoinSets2 set;
	public HashMap<Node, Node> ancestorMap;
	public Tarjan1() {
		this.queryMap = new HashMap<>();
		this.indexMap = new HashMap<>();
		this.set = new DisjoinSets2();
		this.ancestorMap = new HashMap<>();
	}
	
	public Node[] query(Query[] query,Node head){
		Node[] ans = new Node[query.length];
		setQuery(query, ans);
		set.makeSets(head);
		setAnswers(head, ans);
		return ans;
	}
	public void setAnswers(Node head,Node[] ans){
		if(head == null){
			return;
		}
		setAnswers(head.left, ans);
		set.union(head.left, head);
		ancestorMap.put(set.findFather(head), head);
		setAnswers(head.right, ans);
		set.union(head.right, head);
		ancestorMap.put(set.findFather(head), head);
		LinkedList<Node> nList = queryMap.get(head);
		LinkedList<Integer> iList = indexMap.get(head);
		while(!nList.isEmpty() && !iList.isEmpty()){
			Node node = nList.poll();
			int index = iList.poll();
			if(ancestorMap.containsKey(set.findFather(node))){
				ans[index] = ancestorMap.get(set.findFather(node));
			}
		}
	}
	
	public void setQuery(Query[] ques,Node[] ans){
		Node o1 = null;
		Node o2 = null;
		for(int i = 0;i<ques.length;i++){
			o1 = ques[i].o1;
			o2 = ques[i].o2;
			if(o1 == o2 || o1 == null || o2 == null){
				ans[i] = o1 == null?o2:o1;
			}else{
				if(!queryMap.containsKey(o1)){
					queryMap.put(o1, new LinkedList());
					indexMap.put(o1, new LinkedList());
				}
				if(!queryMap.containsKey(o2)){
					queryMap.put(o2, new LinkedList());
					indexMap.put(o2, new LinkedList());
				}
				queryMap.get(o1).add(o2);
				indexMap.get(o1).add(i);
				queryMap.get(o2).add(o1);
				indexMap.get(o2).add(i);
			
			}
		}
	}
	
	
}
