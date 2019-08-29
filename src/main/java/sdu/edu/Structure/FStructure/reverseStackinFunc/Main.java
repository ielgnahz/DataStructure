package sdu.edu.Structure.FStructure.reverseStackinFunc;

import java.util.Stack;

public class Main {
	public void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int value = getfoot(stack);
		reverseStack(stack);
		stack.push(value);
	}

	public int getfoot(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getfoot(stack);
			stack.push(result);
			return last;
		}
	}
}
