package sdu.edu.Structure.FifthStructure.minLength;

public class Main {
	public int minLength(String arr1,String arr2){
		char[] str1 = arr1.toCharArray();
		char[] str2 = arr2.toCharArray();
		int match = str2.length;
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		int[] map = new int[256];
		for(int i = 0;i<str2.length;i++){
			map[str2[i]]++;
		}
		while(right < str1.length){
			map[str1[right]]--;
			if(map[str1[right]] >= 0){
				match--;
			}
			if(match == 0){
				while(map[str1[left]] < 0){
					map[str1[left++]]++;
				}
				match++;
				min = Math.min(min, right-left+1);
				map[str1[left++]]++;
			}
			right++;
		}
		return min == Integer.MAX_VALUE?0:min;
	}
	public static void main(String[] args) {
		System.out.println(new Main().minLength("ababdbcda", "acb"));
	}
}
