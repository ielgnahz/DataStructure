package sdu.edu.Structure.ThirdStructure.preInToTree;

import java.util.HashMap;

public class Main1 {
	public Node perInToTree(int[] pre, int[] in) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return perIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}

	public Node inposToTree(int[] in, int[] pos) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return inPos(in, 0, in.length - 1, pos, 0, pos.length - 1, map);
	}

	public Node perPosToTree(int[] per, int[] pos) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < pos.length; i++) {
			map.put(pos[i], i);
		}
		return perPos(per, 0, per.length - 1, pos, 0, pos.length - 1, map);
	}

	public Node perIn(int[] p, int pi, int pj, int[] n, int ni, int nj,
			HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return null;
		}
		// index-ni的值就是要中序数组长度，ni为中序数组开头，index为中序数组中p[pi]所在位置，一减为偏移
		Node head = new Node(p[pi]);
		int index = map.get(p[pi]);
		head.left = perIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
		head.right = perIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
		return head;
	}

	public Node inPos(int[] n, int ni, int nj, int[] s, int si, int sj,
			HashMap<Integer, Integer> map) {
		if (si > sj) {
			return null;
		}
		Node head = new Node(s[sj]);
		int index = map.get(s[sj]);
		head.left = inPos(n, ni, index - 1, s, si + index - ni - 1, sj - 1, map);
		head.right = inPos(n, index + 1, nj, s, si, si + index - ni, map);
		return head;
	}
	
	public Node perPos(int[] p,int pi,int pj,int[] s,int si,int sj,HashMap<Integer, Integer> map){
		if(pi > pj){
			return null;
		}
		Node head = new Node(s[sj--]);
		int index = map.get(p[++pi]);
		head.left = perPos(p, pi, pi+index-si, s, si, index, map);
		head.right = perPos(p, pi+index-si+1, pj, s, index+1, sj, map);
		return head;
	}

}
