package sdu.edu.Structure.FourthStructure.jump;

public class Main1 {
	public int jump(int[] arr){
		if(arr == null){
			return 0;
		}
		int jump = 0;
		int cur = 0;
		int next = 0;
		for(int i = 0;i<arr.length;i++){
			if(cur < i){
				jump++;
				cur = next;
			}
			next = Math.max(next, i+arr[i]);
		}
		return jump;
	}
}
