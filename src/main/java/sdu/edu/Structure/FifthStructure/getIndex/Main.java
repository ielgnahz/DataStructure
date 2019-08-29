package sdu.edu.Structure.FifthStructure.getIndex;

public class Main {
	public int getIndex(String[] strs,String str){
		if(str == null){
			return -1;
		}
		int left = 0;
		int right = strs.length;
		int mid = 0;
		int res = 0;
		while(left <= right){
			mid = (left + right)/2;
			if(strs[mid] == str){
				right = mid-1;
				res = mid;
			}else if(strs[mid] != null){
				if(strs[mid].compareTo(str) > 0){
					right = mid-1;
				}else{
					left = mid+1;
				}
			}else{
				int i = mid;
				while(strs[i] == null  && --i>=left){
					
				}
				if(i < left || strs[i].compareTo(str) < 0){
					left = mid+1;
				}else{
					res = strs[i] == str?i:res;
					right = i-1;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new Main().getIndex(new String[]{null,"a",null,"a",null,"b",null,"c"}, "c"));
	}
}
