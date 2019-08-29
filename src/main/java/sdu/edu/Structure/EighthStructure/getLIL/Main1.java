package sdu.edu.Structure.EighthStructure.getLIL;

import java.util.HashSet;

public class Main1 {
	public int getLIL(int[] arr){
		int max = 0;
		int min = 0;
		int len = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			max = Integer.MIN_VALUE;
			min =- Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) {
				if(set.contains(arr[j])){
					break;
				}
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				if(max - min == j-i){
					len = Math.max(len, j-i+1);
				}
			}
			set.clear();
		}
		return len;
	}
}
