package sdu.edu.Structure.FifthStructure.Sort;

import java.util.*;

public class Solution implements Comparator<String> {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 根据先序和中序数组创建树
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode head = new TreeNode(pre[0]);
		int index = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				index = i;
			}
		}
		int[] preLeft = new int[index];
		int[] preRight = new int[in.length - index - 1];
		int[] inLeft = new int[index];
		int[] inRight = new int[in.length - index - 1];
		for (int i = 0; i < index; i++) {
			preLeft[i] = pre[i + 1];
			inLeft[i] = in[i];
		}

		for (int i = 0; i < pre.length - index - 1; i++) {
			preRight[i] = pre[i + index + 1];
			inRight[i] = in[i + index + 1];
		}
		if (preLeft.length > 0) {
			head.left = reConstructBinaryTree(preLeft, inLeft);
		}
		if (preRight.length > 0) {
			head.right = reConstructBinaryTree(preRight, inRight);
		}
		return head;
	}

	/*
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
	 */
	public int minNumberInRotateArray(int[] array) {
		if (array[0] < array[array.length - 1]) {
			return array[0];
		} else if (array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (right - left == 1) {
				break;
			}
			int mid = (left + right) / 2;
			if (array[left] < array[mid]) {
				left = mid;
			} else if (array[left] > array[mid]) {
				right = mid;
			} else {
				left = array[0];
				for (int i = 1; i < array.length; i++) {
					if (array[i] < left) {
						left = i;
						break;
					}
				}
				break;
			}
		}
		return array[right];
	}

	/*
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 */
	public int NumberOf1(int n) {
		int flag = 1;
		int count = 0;
		while (flag != 0) {
			if ((flag & n) != 0) {
				count++;
			}
			flag <<= 1;
		}
		return count;
	}

	/*
	 * public int NumberOf1(int n) { int count = 0; while(n != 0){ ++count;
	 * n=n&(n-1); } return count; }
	 */

	/*
	 * 
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	 */
	public static double Power(double base, int exponent) {
		boolean flag = false;
		if (exponent < 0) {
			if (base == 0) {
				return 0.0;
			}
			exponent = -exponent;
			flag = true;
		}
		double result = 1;
		for (; exponent != 0; exponent >>= 1) {
			if ((exponent & 1) != 0) {
				result = result * base;
			}
			base = base * base;
		}
		if (flag) {
			result = 1 / result;
		}
		return result;
	}

	/*
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，
	 * 偶数和偶数之间的相对位置不变。
	 */
	public static void reOrderArray(int[] array) {
		int pivot = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				int tmp = array[i];
				int j = i;
				for (; j > pivot; j--) {
					array[j] = array[j - 1];
				}
				pivot++;
				array[j] = tmp;
			}
		}
	}

	/*
	 * 输入一个链表，输出该链表中倒数第k个结点。
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode cur = head;
		ListNode next = head;
		int count = 1;
		while (count != k && next != null) {
			count++;
			next = next.next;
		}
		if (next == null) {
			return null;
		}
		while (next.next != null) {
			next = next.next;
			cur = cur.next;
		}
		return cur;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 操作给定的二叉树，将其变换为源二叉树的镜像。
	 */
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;
		Mirror(root.left);
		Mirror(root.right);
	}

	/*
	 * 
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5
	 * 是某栈的压入顺序
	 * ，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
	 */
	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int j = 0;
		while (j < popA.length) {
			if (stack.isEmpty() || stack.peek() != popA[j]) {
				if (i == pushA.length) {
					break;
				}
				stack.push(pushA[i]);
				i++;
			} else {
				j++;
				stack.pop();
			}
		}
		return j == popA.length;

	}

	/*
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac
	 * ,bca,cab和cba。
	 */
	private ArrayList<String> list = new ArrayList<>();

	public ArrayList<String> Permutation(String str) {
		if (str.equals("") || str == null) {
			return list;
		}
		char[] strs = str.toCharArray();
		Recursion(strs, 0);
		Collections.sort(list);
		return list;
	}

	public void Recursion(char[] strs, int index) {
		if (index == strs.length - 1) {
			String str = String.valueOf(strs);
			if (!list.contains(str)) {
				list.add(str);
			}
		} else {
			for (int i = index; i < strs.length; i++) {
				swap(strs, index, i);
				Recursion(strs, index + 1);
				swap(strs, index, i);
			}
		}

	}

	public void swap(char[] strs, int i, int j) {
		char tmp = strs[i];
		strs[i] = strs[j];
		strs[j] = tmp;
	}

	/*
	 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 */
	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input == null || input.length == 0 || k > input.length || k == 0) {
			return new ArrayList();
		}
		ArrayList<Integer> list = new ArrayList<>();
		int m = Partition(input, 0, input.length - 1);
		int left = 0;
		int right = input.length - 1;
		while (m != k - 1) {
			if (m > k - 1) {
				right = m - 1;
				m = Partition(input, left, right);
			} else {
				left = m + 1;
				m = Partition(input, left, right);
			}
		}
		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}
		Collections.sort(list);
		return list;
	}

	public static int Partition(int[] arr, int start, int end) {
		int left = start - 1;
		int k = randomRange(start, end);
		swap(arr, end, k);
		for (int i = start; i < end; i++) {
			if (arr[i] <= arr[end]) {
				swap(arr, i, ++left);
			}
		}
		swap(arr, end, ++left);
		return left;
	}

	public static int randomRange(int min, int max) {
		if (min == 0 && max == 0) {
			return 0;
		}
		Random random = new Random();
		return random.nextInt(max) % (max - min + 1) + min;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// 另一種做法
	/*
	 * public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input == null || input.length == 0 || k > input.length || k == 0) {
			return new ArrayList();
		}
		ArrayList<Integer> list = new ArrayList<>();
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = input[i];
		}
		buildHeap(result);
		for (int i = k; i < input.length; i++) {
			if (input[i] < result[0]) {
				result[0] = input[i];
				heapify(result, 0, result.length);
			}
		}
		for (int i = 0; i < k; i++) {
			list.add(result[i]);
		}
		return list;
	}

	public void buildHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
	}

	public void heapify(int[] arr, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if (left < size && arr[left] > arr[max]) {
			max = left;
		}
		if (right < size && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			swap(arr, max, i);
			heapify(arr, max, size);
		}
	}
	 */

	/*
	 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13
	 * 因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到
	 * n 中1出现的次数）。
	 */

	public int NumberOf1Between1AndN_Solution(int n) {
		if (n < 1) {
			return 0;
		}
		int len = getLenOfNum(n);
		if (len == 1) {
			return 1;
		}
		int tmp = (int) Math.pow(10, len - 1);
		int first = n / tmp;
		int firstNum = first == 1 ? n % tmp + 1 : tmp;
		int otherNum = first * (len - 1) * (tmp / 10);
		return firstNum + otherNum + NumberOf1Between1AndN_Solution(n % tmp);
	}

	public int getLenOfNum(int n) {
		int len = 1;
		while (n / 10 != 0) {
			n++;
			n = n / 10;
		}
		return n;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 1);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// reOrderArray(A);
		// for (int i = 0; i < A.length; i++) {
		// System.out.print(A[i] + " ");
		// }
		// String str = "abc";
		// System.out.println(Permutation(str).toString());
		// ArrayList<Integer> list = new ArrayList<>();
		// Vector<Integer> vector = new Vector<>();
		// System.out.println(IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[]
		// {
		// 4, 3, 5, 1, 2 }));
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return (o1+o2).compareTo(o2+o1);
	}
	
	

}
