package sdu.edu.Structure.FifthStructure.isUnique;

import java.util.HashMap;

public class Main {
	public boolean isUnique(char[] arr) {
		boolean[] flag = new boolean[256];
		for (int i = 0; i < arr.length; i++) {
			if (flag[arr[i]]) {
				return false;
			}
			flag[arr[i]] = true;
		}
		return true;
	}

	public boolean isUnique1(char[] arr) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				return false;
			}
			map.put(arr[i], 1);
		}
		return true;
	}

	public boolean isUnique2(char[] arr) {
		HeadSort(arr);
		for(int i = 1;i<arr.length;i++){
			if(arr[i] == arr[i-1]){
				return false;
			}
		}
		return true;
	}

	public void HeadSort(char[] arr) {
		int len = arr.length;
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			HeadInteration(arr, i, len);
		}
		if(len!= 0){
			swap(arr, 0, --len);
			HeadInteration(arr, 0, len);
		}
		
	}
	public void swap(char[] arr,int a,int b){
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public void HeadInteration(char[] arr, int i, int size) {
		char cur = arr[i];
		for(int k = 2*i+1;k<size-1;k = 2*k+1){
			if(k+1<size && arr[k] < arr[k+1]){
				k = k+1;
			}
			if(arr[k]>cur){
				arr[i] = arr[k];
				i = k;
			}else{
				break;
			}
		}
		arr[i] = cur;
	}

	public static void main(String[] args) {
		System.out.println(new Main()
				.isUnique2(new char[] { 'a', 'b', 'c' }));
	}
}
