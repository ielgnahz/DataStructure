package sdu.edu.Structure.ThirdStructure.preInToTree;

import java.util.HashMap;

public class Main {
	public Node preInToTree(int[] pre,int[] in){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i<in.length;i++){
			map.put(in[i], i);
		}
		return preOrder(pre, 0, pre.length-1, in, 0, in.length-1, map);
		
	}
	public Node preOrder(int[] pre,int pi,int pj,int[] in,int ni,int nj,HashMap<Integer, Integer> map){
		if(pi > pj){
			return null;
		}
		Node head = new Node(pre[pi]);
		int index = map.get(pre[pi]);
		head.left = preOrder(pre, pi+1, pi + index - ni, in, ni, index-1, map);
		head.right = preOrder(pre, pi + index - ni + 1, pj, in, index + 1, nj, map);
		return head;
	}
	public Node inPos(int[] n,int ni,int nj,int[] s,int si,int sj,HashMap<Integer, Integer>  map){
		if(si > sj){
			return null;
		}
		Node head = new Node(s[sj]);
		int index = map.get(s[sj]);
		head.left = inPos(n, ni, index-1, s, si, sj+index-ni-1, map);
		head.right = inPos(n, index+1, nj, s, si + index - ni, sj-1, map);
		return head;
	}
	public Node perPos(int[] pre,int pi,int pj,int[] pos,int si,int sj,HashMap<Integer, Integer> map){
		Node head = new Node(pos[sj--]);
		if(pi == pj){
			return head;
		}
		int index = map.get(pre[++pi]);
		head.left = perPos(pre, pi, pi + index - si, pos, si, index, map);
		head.right = perPos(pre, pi+index-si+1, pj, pos, index+1, sj, map);  
		return head;
	}
	
}
