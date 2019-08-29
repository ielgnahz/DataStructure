package sdu.edu.Structure.FourthStructure.hanoi;

public class Main {
	public void hanoi(int n){
		if(n < 1){
			return;
		}
		func(n,"left","mid","right");
	}
	public void func(int n,String from,String mid,String to){
		if(n == 1){
			System.out.println("from "+from+" to "+to);
		}else{
			func(n-1, from, to, mid);
			func(1, from, mid, to);
			func(n-1, mid, from, to);
		}
	}
	
	public int step1(int[] arr){
		return process1(arr,arr.length-1,1,2,3);
	}
	public int process1(int[] arr,int i,int from,int mid,int to){
		if(i == -1){
			return 0;
		}
		if(arr[i]!=from && arr[i]!=to){
			return -1;
		}
		if(arr[i] == from){
			return process1(arr, i-1, from, to, mid);
		}else{
			int res = process1(arr, i-1, mid, from, to);
			if(res == -1){
				return-1;
			}
			return (1<<i)+res;
		}
	}
	
	public static void main(String[] args) {
		new Main().hanoi(3);
	}
	
}
