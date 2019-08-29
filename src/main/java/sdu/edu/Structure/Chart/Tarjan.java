package sdu.edu.Structure.Chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Tajan求有向图的强连通分量
public class Tarjan {
	public ArrayList<Integer>[] graph;
	public List<ArrayList<Integer>> result;
	public int numOfNode;
	public boolean[] inStack;
	public Stack<Integer> stack;
	public int[] dfs;
	public int[] low;
	public int time;
	
	public Tarjan(ArrayList<Integer>[] graph,int numOfNode){
		this.graph = graph;
		this.numOfNode = numOfNode;
		this.inStack = new boolean[numOfNode];
		this.stack = new Stack<>();
		dfs = new int[numOfNode];
		low = new int[numOfNode];
		Arrays.fill(dfs, -1);
		Arrays.fill(low, -1);
		result = new ArrayList<>();
	}
	
	public List<ArrayList<Integer>> Go(){
		for (int i = 0; i < numOfNode; i++) {
			if(dfs[i] == -1){
				tarjan(i);
			}
		}
		return result;
	}
	public void tarjan(int current){
		dfs[current] = low[current] = time++;
		inStack[current] = true;
		stack.push(current);
		
		for (int i = 0; i < graph.length; i++) {
			int next = graph[i].get(i);
			if(dfs[i] == -1){
				tarjan(i);
				low[current] = Math.min(low[current], low[next]);
			}else if(inStack[next]){
				low[current] = Math.min(low[current], dfs[next]);
			}
		}
		
		if(low[current] == dfs[current]){
			ArrayList<Integer> tmp = new ArrayList<>();
			int j = -1;
			while(current != j){
				j = stack.pop();
				inStack[j] = false;
				tmp.add(j);
			}
			result.add(tmp);
		}
	}
}
