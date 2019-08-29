package sdu.edu.Structure.FifthStructure.getValue;

import java.util.Deque;
import java.util.LinkedList;

public class Main1 {
	public int getValue(String str){
		return Value(str,0)[0];
	}
	public int[] Value(String arr,int i){
		int pre = 0;
		int[] bra = null;
		Deque<String> deq = new LinkedList<String>();
		char[] str = arr.toCharArray();
		while(i < str.length && str[i] != ')'){
			if(str[i] >='0' && str[i]<='9'){
				pre = pre * 10 + str[i++] - '0';
			}else if(str[i] != '('){
				addNum(deq,pre);
				deq.addLast(str[i++]+"");
				pre = 0;
			}else{
				bra = Value(arr, i+1);
				pre = bra[0];
				i = bra[1]+1;
			}
		}
		addNum(deq, pre);
		return new int[]{getNum(deq),i};
	}
	public void addNum(Deque<String> deq,int num){
		String top = deq.pollLast();
		if(!deq.isEmpty()){
			if(top.equals("+")|| top.equals("-")){
				deq.addLast(top);
			}else{
				int cur = Integer.valueOf(deq.pollLast());
				num = top.equals("*")?cur * num : cur / num;
			}
		}
		deq.addLast(String.valueOf(num));
	}
	public int getNum(Deque<String> deq){
		boolean flag = true;
		int num = 0;
		while(!deq.isEmpty()){
			String top = deq.pollFirst();
			if(top.equals("-")){
				flag = false;
			}else if(top.equals("+")){
				flag = true;
			}else{
				int cur = Integer.valueOf(top);
				num += flag?cur:-cur;
			}
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(new Main1().getValue("48*((78-65)-43)+8*1"));
	}
}
