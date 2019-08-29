package sdu.edu.Structure.FifthStructure.maxUnique;

import java.util.HashMap;

public class Main {
	public int maxUnique(String arr){
		char[] str = arr.toCharArray();
		int pre = -1;
		HashMap<Character, Integer> map = new HashMap<>();
		int a = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < str.length;i++){
			if(map.containsKey(str[i])){
				a = map.get(str[i]);
				if(pre < a){
					max = Math.max(max, i-a);
				}else{
					max = Math.max(max, i-pre);
				}
				pre = Math.max(a, pre);
				map.put(str[i], i);
			}else{
				map.put(str[i], i);
				max = Math.max(max, i-pre);
			}
		}
		return max;
	}
	public int maxUnique1(String arr){
		char[] str = arr.toCharArray();
		int pre = -1;
		int len = 0;
		int[] map = new int[256];
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		for (int i = 0; i < str.length; i++) {
			pre = Math.max(pre, map[str[i]]);
			len = Math.max(len, i-pre);
			map[str[i]] = i;
		}
		return len;
	}
	public static void main(String[] args) {
		System.out.println(new Main().maxUnique1("aabcd"));
	}
}
