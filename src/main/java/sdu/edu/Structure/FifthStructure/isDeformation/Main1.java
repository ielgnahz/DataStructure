package sdu.edu.Structure.FifthStructure.isDeformation;

public class Main1 {
	public boolean isDeformation(String arr1,String arr2){
		char[] str1 = arr1.length()>arr2.length()?arr2.toCharArray():arr1.toCharArray();
		char[] str2 = arr1.length()>arr2.length()?arr1.toCharArray():arr2.toCharArray();
		int[] map = new int[256];
		for(int i = 0;i<str1.length;i++){
			map[str1[i]]++;
		}
		for(int j = 0;j<str2.length;j++){
			if(map[str2[j]]-- == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().isDeformation("1223", "123"));
	}
}
