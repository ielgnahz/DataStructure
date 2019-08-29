package sdu.edu.Structure.FifthStructure.getValue;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public int getValue(String arr){
		return value(arr.toCharArray(),0)[0];
	}
	public int[] value(char[] str,int i){
		int pre = 0;
		int[] bra = null;
		Deque<String> deq = new LinkedList<String>();
		while(i < str.length && str[i] != ')'){
			if(str[i] >= '0' && str[i]<='9'){
				pre = pre * 10 + str[i++]-'0';
			}else if(str[i] != '('){
				addNum(deq,pre);
				deq.addLast(String.valueOf(str[i++]));
				pre = 0;
			}else{
				bra = value(str, i+1);
				i = bra[1]+1;
				pre = bra[0];
			}
		}
		addNum(deq, pre);
		return new int[]{getNum(deq),i};
	}
	public void addNum(Deque<String> deq,int num){
		String top = null;
		int cur = 0;
		if(!deq.isEmpty()){
			top = deq.pollLast();
			if(top.equals("+")  || top.equals("-")){
				deq.addLast(top);
			}else{
				cur = Integer.valueOf(deq.pollLast());
				num = top.equals("*")?cur * num:cur / num;
			}
		}
		deq.addLast(String.valueOf(num));
	}
	public int getNum(Deque<String> deq){
		boolean flag = true;
		String str = null;
		int num = 0;
		int cur = 0;
		while(!deq.isEmpty()){
			str = deq.pollFirst();
			if(str.equals("+")){
				flag = true;
			}else if(str .equals("-")){
				flag = false;
			}else{
				cur = Integer.valueOf(str);
				num += flag?cur:-cur;
			}
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(new Main().getValue("48*((78-65)-43)+8*1"));
	}
}
