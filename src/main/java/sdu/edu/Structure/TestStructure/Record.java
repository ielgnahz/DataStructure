package sdu.edu.Structure.TestStructure;

import java.util.HashMap;
import java.util.Map.Entry;


public class Record {
	public HashMap<String, HashMap<String, Integer>> record;
	public Record(String[] strs){
		record=  new HashMap<>();
		HashMap<String, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String curStr = strs[i];
			update(indexMap,curStr,i);
			indexMap.put(curStr, i);
		}
	}
	public void update(HashMap<String, Integer> indexMap,String curStr,int i){
		if(!record.containsKey(curStr)){
			record.put(curStr, new HashMap());
		}
		HashMap<String, Integer> strMap = record.get(curStr);
		for(Entry<String, Integer> entry:indexMap.entrySet()){
			String key = entry.getKey();
			int value = entry.getValue();
			if(!key.equals(curStr)){
				HashMap<String, Integer> reMap = record.get(key);
				int curMin = i - value;
				if(strMap.containsKey(key)){
					if(curMin < strMap.get(key)){
						strMap.put(key, curMin);
						reMap.put(curStr, curMin);
					}
				}else{
					strMap.put(key, curMin);
					reMap.put(curStr, curMin);
				}
			}
		}
	} 
	public int misDistance(String str1,String str2){
		if(record.containsKey(str1) && record.get(str1).containsKey(str2)){
			return record.get(str1).get(str2);
		}
		return -1;
	}
}
