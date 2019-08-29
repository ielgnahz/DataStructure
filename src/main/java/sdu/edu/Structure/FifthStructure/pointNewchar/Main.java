package sdu.edu.Structure.FifthStructure.pointNewchar;

public class Main {
	public String pointNewchar(String arr,int k){
		char[] str = arr.toCharArray();
		int num = 0;
		for(int i = k-1;i>=0;i--){
			if(str[i] >=65 && str[i] <= 90){
				num++;
			}else{
				break;
			}
		}
		if(num % 2 != 0){
			return arr.substring(k-1, k+1);
		}else if(str[k]>=65 && str[k]<=90){
			return arr.substring(k, k+2);
		}else{
			return arr.substring(k, k+1);
		}
		
	}
	public static void main(String[] args) {
		System.out.println(new Main().pointNewchar("aaABCDEcBCg", 4));
	}
}
