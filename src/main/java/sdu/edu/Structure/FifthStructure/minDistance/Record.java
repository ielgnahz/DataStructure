package sdu.edu.Structure.FifthStructure.minDistance;

import java.util.HashMap;
import java.util.Map.Entry;

public class Record {
	public HashMap<String, HashMap<String, Integer>> record;
	public Record(String[] strs){
		record = new HashMap<>();
		HashMap<String, Integer> indexMap = new HashMap<>();
		for(int i = 0;i<strs.length;i++){
			update(indexMap,strs[i],i);
			indexMap.put(strs[i], i);
		}
	}
	public void update(HashMap<String, Integer> indexMap,String str,int i){
		if(!record.containsKey(str)){
			record.put(str, new HashMap());
		}
		HashMap<String, Integer> strMap = record.get(str);
		for(Entry<String, Integer> entry : indexMap.entrySet()){
			String key = entry.getKey();
			int value = entry.getValue();
			if(!key.equals(str)){
				int curMin = i - value;
				HashMap<String, Integer> lastMap = record.get(key);
				if(strMap.containsKey(key)){
					int preMin = strMap.get(key);
					if(preMin > curMin){
						strMap.put(key, curMin);
						lastMap.put(str, curMin);
					}
				}else{
					strMap.put(key, curMin);
					lastMap.put(str, curMin);
				}
			}
		}
	}
	public int minDistance(String str1,String str2){
		if(str1 == null || str2 == null){
			return -1;
		}
		if(str1 == str2){
			return 0;
		}
		if(record.containsKey(str1) && record.get(str1).containsKey(str2)){
			return record.get(str1).get(str2);
		}
		return -1;
	}
	public static void main(String[] args) {
		String[] strs = new String[]{"1","3","3","3","2","3","1"};
		System.out.println(new Record(strs).minDistance("2", "1"));
	}
}
