package sdu.edu.Structure.EighthStructure.MaxLength;

public class Main {
	public int MaxLength(int[] arr,int k){
		int sum = 0;
		int[] h = new int[arr.length+1];
		h[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			h[i+1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int pre = 0;
		int len = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1?0:i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}
	public int getLessIndex(int[] arr,int num){
		int left = 0;
		int right = arr.length-1;
		int mid = 0;
		int res = -1;
		while(left <= right){
			mid = (left + right) / 2;
			if(arr[mid] >= num){
				res = mid;
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return res;
	}
}
