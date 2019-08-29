package sdu.edu.Structure.FifthStructure.lowestString;

import java.util.Arrays;

public class Main {
	public String lowestString(String[] str){
		Arrays.sort(str,new Mycomparator());
		String res = "";
		for (int i = 0; i < str.length; i++) {
			res+=str[i];
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new Main().lowestString(new String[]{"abc","de"}));
	}
}
