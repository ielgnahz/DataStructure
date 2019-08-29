package sdu.edu.Structure.FifthStructure.Main;
public class Main {
	public void modify(String str){
		char[] arr = str.toCharArray();
		int index = arr.length-1;
		for(int i = arr.length-1;i>=0;i--){
			if(arr[i]!='*'){
				arr[index--] = arr[i];
			}
		}
		for(int i = index;i>=0;i--){
			arr[i] = '*';
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	public void replace(char[] arr){
		int num = 0;
		int len = 0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i] == ' '){
				num++;
			}else if(arr[i] == 0){
				break;
			}
			len++;
		}
		int length = len + 2 * num;
		for(int i = len-1;i>=0;i--){
			if(arr[i] == ' '){
				arr[--length] = '0';
				arr[--length] = '2';
				arr[--length] = '%';
			}else{
				arr[--length] = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	public static void main(String[] args) {
//		new Main().replace(new char[]{'a',' ','b',' ',' ','c',0,0,0,0,0,0,0,0,0});
		new Main().modify("12***345");
	}
}