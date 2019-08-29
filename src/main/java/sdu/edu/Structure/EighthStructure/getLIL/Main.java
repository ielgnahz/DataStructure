package sdu.edu.Structure.EighthStructure.getLIL;

import java.util.HashSet;

public class Main {
	public int getLIL(int[] arr){
		HashSet<Integer> set = new HashSet<>();
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < arr.length; j++) {
				if(set.contains(arr[j])){
					break;
				}
				set.add(arr[j]);
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				if(max - min == j - i){
					len = Math.max(j-i+1, len);
				}
			}
			set.clear();
		}
		return len;
	}
	public static void main(String[] args) {
		System.out.println(new Main().getLIL(new int[]{5,5,3,2,6,4,3}));;
	}
}
