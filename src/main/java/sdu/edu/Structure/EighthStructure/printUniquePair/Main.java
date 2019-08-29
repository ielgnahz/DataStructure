package sdu.edu.Structure.EighthStructure.printUniquePair;

public class Main {
	public void printUniquePair(int[] arr,int k){
		int left = 0;
		int right = arr.length - 1;
		while(left < right){
			if(arr[left] + arr[right] < k){
				left++;
			}else if(arr[left] + arr[right] > k){
				right--;
			}else{
				if(left == 0 || arr[left] != arr[left-1]){
					System.out.println(arr[left]+" "+ arr[right]);
				}
				left++;
				right--;
			}
		}
	}
	
	public void printUniqueTriad(int[] arr,int k){
		for (int i = 0; i < arr.length; i++) {
			if(i == 0 || arr[i] != arr[i-1]){
				printRest(arr,i,i+1,arr.length-1,k-arr[i]);
			}
		}
	}
	public void printRest(int[] arr,int f,int l,int r,int k){
		while(l < r){
			if(arr[l] + arr[r] < k){
				l++;
			}else if(arr[l] + arr[r] > k){
				r--;
			}else{
				if(l == f+1 || arr[l] != arr[l-1]){
					System.out.println(arr[f]+" "+arr[l] + " "+arr[r]);
				}
				l++;
				r--;
			}
		}
	}
	public static void main(String[] args) {
//		new Main().printUniquePair(new int[]{-8,-4,-3,0,1,2,4,5,8,9}, 10);
		new Main().printUniqueTriad(new int[]{-8,-4,-3,0,1,2,4,5,8,9}, 10);
	}
	
}
