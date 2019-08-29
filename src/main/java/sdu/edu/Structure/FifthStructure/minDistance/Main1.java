package sdu.edu.Structure.FifthStructure.minDistance;

public class Main1 {
	public int minDistance(String[] strs,String str1,String str2){
		int last1 = -1;
		int last2 = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<strs.length;i++){
			if(strs[i].equals(str1)){
				min = Math.min(min, last2 == -1?min:i-last2);
				last1 = i;
			}
			if(strs[i].equals(str2)){
				min = Math.min(min, last1 == -1?min:i-last1);
				last2 = i;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().minDistance(new String[]{"1","3","3","3","2","3"}, "1", "2"));
	}
}
