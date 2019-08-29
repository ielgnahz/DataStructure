package sdu.edu.Structure.EighthStructure.printHalMajor;

public class Main1 {
	public void printHalMajor(int[] arr){
		int time = 0;
		int cand = 0;
		for (int i = 0; i < arr.length; i++) {
			if(time == 0){
				cand = arr[i];
			}else if(cand == arr[i]){
				time++;
			}else{
				time--;
			}
		}
		time = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == cand){
				time++;
			}
		}
		if(time > arr.length / 2){
			System.out.println(cand);
		}else{
			System.out.println("no number");
		}
	}
}
