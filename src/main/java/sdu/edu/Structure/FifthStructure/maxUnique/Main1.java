package sdu.edu.Structure.FifthStructure.maxUnique;

public class Main1 {
	public int maxUnique1(String arr){
		char[] str = arr.toCharArray();
		int[] map = new int[256];
		int pre = -1;
		int len = 0;
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		for (int i = 0; i < str.length; i++) {
			pre = Math.max(pre, map[str[i]]);
			len = Math.max(len, i - pre);
			map[str[i]] = i;
		}
		return len;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().maxUnique1("abbcde"));
	}
}
