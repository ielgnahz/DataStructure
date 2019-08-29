package sdu.edu.Structure.FifthStructure.rotate;

public class Main {
	public void rotate(String arr){
		char[] str = arr.toCharArray();
		int l = 0;
		reverse(str, 0, str.length-1);
		for(int i = 0;i<str.length;i++){
			if(str[i] == ' '){
				reverse(str, l, i-1);
				l = i+1;
			}
		}
		reverse(str, l, str.length-1);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
	}
	
	public void rotate1(String arr,int size){
		char[] str = arr.toCharArray();
		reverse(str, 0, str.length-1);
		reverse(str, 0, str.length-size-1);
		reverse(str, str.length-size, str.length-1);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
	}
	
	public void rotate2(String str,int size){
		char[] arr = str.toCharArray();
		int start = 0;
		int end = arr.length-1;
		int lpart = size;
		int rpart = arr.length-size;
		int d = lpart - rpart;
		int s = Math.min(lpart, rpart);
		while(true){
			exchange(arr,start,end,s);
			if(d == 0){
				break;
			}else if(d > 0){
				start += s;
				lpart = d;
			}else{
				end -=s;
				rpart = -d;
			}
			s = Math.min(lpart, rpart);
			d = lpart - rpart;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	public void exchange(char[] arr,int start,int end,int size){
		int i = end - size + 1;
		char tmp = 0;
		while(size-- != 0){
			tmp = arr[start];
			arr[start] = arr[i];
			arr[i] = tmp;
			start++;
			i++;
		}
	}
	
	
	public void reverse(char[] str,int start,int end){
		char tmp = 0;
		while(start < end){
			tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
//		new Main().rotate("I'm a student.");
		new Main().rotate2("ABCDE", 3);
	}
}	
