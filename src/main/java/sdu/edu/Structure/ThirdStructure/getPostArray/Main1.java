package sdu.edu.Structure.ThirdStructure.getPostArray;

import java.util.HashMap;

public class Main1 {
	public int[] getPostArray(int[] pre,int[] in){
		if(pre == null || in == null){
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] pos = new int[pre.length];
		for(int i =0;i<in.length;i++){
			map.put(in[i], i);
		}
		perIn(pre,0,pre.length,in,0,in.length,pos,pos.length-1,map);
		return pos;
	}
	public int perIn(int[] p,int pi,int pj,int[] n,int ni,int nj,int[] pos,int len,HashMap<Integer, Integer> map){
		if(pi > pj){
			return len;
		}
		pos[len--] = p[pi];
		int index = map.get(p[pi]);
		len = perIn(p, pi+index-ni+1, pj, n, index+1, nj, pos, len, map);
		return perIn(p, pi+1, pi+index-ni, n, ni, index-1, pos, len, map);
	}
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,8,9,3,6,7};
		int[] in = {4,2,8,5,9,1,6,3,7};
		int[] a = new Main().getPosArray(pre, in);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
