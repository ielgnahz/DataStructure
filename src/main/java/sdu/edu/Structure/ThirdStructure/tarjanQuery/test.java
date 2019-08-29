package sdu.edu.Structure.ThirdStructure.tarjanQuery;

import java.util.HashMap;

public class test {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(1, map.get(1)+1);
		System.out.println(map.get(1));
	}
}
