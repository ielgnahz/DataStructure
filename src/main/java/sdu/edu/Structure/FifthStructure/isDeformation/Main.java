package sdu.edu.Structure.FifthStructure.isDeformation;

public class Main {
	public boolean isDeformation(String arr1,String arr2){
		if(arr1 == null || arr2 == null || arr1.length() == 0 || arr2.length() == 0){
			return false;
		}
		char[] str1 = arr1.length()>arr2.length()?arr2.toCharArray():arr1.toCharArray();
		char[] str2 = arr1.length()>arr2.length()?arr1.toCharArray():arr2.toCharArray();
//		char[] str1 = arr1.toCharArray();
//		char[] str2 = arr2.toCharArray();
		int[] map = new int[256];
		for(int i = 0;i<str1.length;i++){
			map[str1[i]]++;
		}
		for(int i = 0;i<str2.length;i++){
			if(map[str2[i]]-- == 0){
				return false;
			}
		}
		return true;
	}
}
