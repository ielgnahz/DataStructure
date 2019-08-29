package sdu.edu.Structure.FifthStructure.rotate;

public class Main1 {
	public char[] rotate(String str) {
		char[] arr = str.toCharArray();
		if (arr == null) {
			return null;
		}
		reverse(arr, 0, arr.length - 1);
		int l = 0;
		int r = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				r = i - 1;
				reverse(arr, l, r);
				l = i + 1;
			}
		}
		reverse(arr, l, arr.length - 1);
		return arr;
	}

	public char[] rotate1(String str,int size) {
		if(str == null){
			return null;
		}
		char[] arr = str.toCharArray();
		reverse(arr, 0, arr.length-1);
		reverse(arr, 0, arr.length-size-1);
		reverse(arr, arr.length-size, arr.length-1);
		return arr;
	}
	
	public char[] rotate(String str,int size){
		char[] arr = str.toCharArray();
		int start = 0;
		int end = arr.length-1;
		int lpart = size;
		int rpart = arr.length - size;
		int s = Math.min(lpart, rpart);
		int d = lpart - rpart;
		while(true){
			exchange(arr,start,end,s);
			if(d == 0){
				break;
			}if(d > 0){
				start +=s;
				lpart = d;
			}else{
				end -=s;
				rpart = -d;
			}
			s = Math.min(lpart, rpart);
			d = lpart - rpart;
		}
		return arr;
	}
	public void exchange(char[] arr,int start,int end,int s){
		char tmp = 0;
		int i = end - s + 1;
//		System.out.println(start);
//		System.out.println(end);
//		System.out.println(s);
		while(s-- != 0){
			tmp = arr[start];
			arr[start] = arr[i];
			arr[i] = tmp;
			start++;
			i++;
		}
	}

	public void reverse(char[] arr, int l, int r) {
		char tmp = 0;
		while (l < r) {
			tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		System.out
				.println(String.valueOf(new Main1().rotate("ABCDE",3)));
	}
}
