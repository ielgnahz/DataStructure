package sdu.edu.Structure.EighthStructure.printHalMajor;

public class Main {
	public void printHalMajor(int[] arr){
		int times = 0;
		int cand = 0;
		for (int i = 0; i < arr.length; i++) {
			if(times == 0){
				cand = arr[i];
				times = 1;
			}else if(cand == arr[i]){
				times++;
			}else{
				times--;
			}
		}
		times = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == cand){
				times++;
			}
		}
		if(times > arr.length / 2){
			System.out.println(cand);
		}else{
			System.out.println("No number");
		}
	}
	public static void main(String[] args) {
		
	}
}
