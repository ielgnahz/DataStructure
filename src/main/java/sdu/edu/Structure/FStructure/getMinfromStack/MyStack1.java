package sdu.edu.Structure.FStructure.getMinfromStack;

import java.util.Stack;

public class MyStack1 {
	public Stack<Integer> sData;
	public Stack<Integer> sMin;

	public MyStack1() {
		sData = new Stack<>();
		sMin = new Stack<>();
	}

	public void push(int value) {
		sData.push(value);
		if (sMin.isEmpty()) {
			sMin.push(value);
		} else if (value <= this.getMin()) {
			sMin.push(value);
		}
	}

	public int pop() {
		int value = sData.pop();
		if (value == this.getMin()) {
			sMin.pop();
		}
		return value;
	}

	public int getMin() {
		if (sMin.isEmpty()) {
			throw new RuntimeException("Your Stack isEmpty");
		}
		return sMin.peek();
	}
}
