package sdu.edu.Structure.EighthStructure.getMaxLength;

public class Main {
	public void getMaxLength(int[] arr,int k){
		int left = 0;
		int right = 0;
		int len = 0;
		int sum = arr[0];
		while(right < arr.length){
			if(sum == k){
				len = Math.max(len, right - left + 1);
				sum-=arr[left++];
			}else if(sum < k){
				right++;
				if(right == arr.length){
					break;
				}
				sum+=arr[right];
			}else{
				sum-=arr[left++];
			}
		}
		System.out.println(len);
	}
	public static void main(String[] args) {
		new Main().getMaxLength(new int[]{1,2,1,1,1}, 3);
	}
}
