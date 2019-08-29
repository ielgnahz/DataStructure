package sdu.edu.Structure.TestStructure;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Main1 {
	public void SortByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();
		int value = 0;
		while (!stack.isEmpty()) {
			if (help.isEmpty()) {
				help.push(stack.pop());
			} else {
				value = stack.pop();
				while (!help.isEmpty() && value < help.peek()) {
					stack.push(help.pop());
				}
				help.push(value);
			}
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

	public int[] getMax(int[] arr, int w) {
		Deque<Integer> deq = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		deq.addLast(0);
		for (int i = 1; i < arr.length; i++) {
			while (!deq.isEmpty() && arr[i] >= arr[deq.peekLast()]) {
				deq.pollLast();
			}
			deq.addLast(i);
			if (i - w > deq.peekFirst() - 1) {
				deq.pollFirst();
			}
			if (i - w >= -1) {
				res[i - w + 1] = arr[deq.peekFirst()];
			}
		}
		return res;
	}

	public Node getMaxTree(int[] arr) {
		HashMap<Node, Node> lMap = new HashMap<>();
		HashMap<Node, Node> rMap = new HashMap<>();
		Stack<Node> stack = new Stack<>();
		Node head = null;
		for (int i = 0; i < arr.length; i++) {
			Node curNode = new Node(arr[i]);
			while (!stack.isEmpty() && stack.peek().value < arr[i]) {
				popStackToMap(lMap, stack);
			}
			stack.push(curNode);
		}
		while (!stack.isEmpty()) {
			popStackToMap(lMap, stack);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			Node curNode = new Node(arr[i]);
			while (!stack.isEmpty() && stack.peek().value < arr[i]) {
				popStackToMap(rMap, stack);
			}
			stack.push(curNode);
		}
		while (!stack.isEmpty()) {
			popStackToMap(rMap, stack);
		}

		for (int i = 0; i < arr.length; i++) {
			Node cur = new Node(arr[i]);
			Node left = lMap.get(cur);
			Node right = rMap.get(cur);
			if (left == null && right == null) {
				head = cur;
			} else if (left == null) {
				if (right.left == null) {
					right.left = cur;
				} else {
					right.right = cur;
				}
			} else if (right == null) {
				if (left.left == null) {
					left.left = cur;
				} else {
					left.right = cur;
				}
			} else {
				Node parent = left.value < right.value ? left : right;
				if (parent.left == null) {
					parent.left = cur;
				} else {
					parent.right = cur;
				}
			}
		}
		return head;
	}

	public int getMaxArea(int[][] map) {
		int[] arr = new int[map[0].length];
		int maxArea = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				arr[j] = map[i][j] == 0 ? 0 : arr[j] + 1;
			}
			maxArea = Math.max(maxArea, getArea(arr));
		}
		return maxArea;
	}

	public int getArea(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * arr[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (arr.length - k - 1) * arr[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	public void popStackToMap(HashMap<Node, Node> map, Stack<Node> stack) {
		Node cur = stack.pop();
		if (stack.isEmpty()) {
			map.put(cur, null);
		} else {
			map.put(cur, stack.peek());
		}
	}

	public void reverseStack(Stack<Integer> stack) {
		int num = getFootNum(stack);
		if (stack.isEmpty()) {
			stack.push(num);
		} else {
			reverseStack(stack);
			stack.push(num);
		}
	}

	public int getFootNum(Stack<Integer> stack) {
		int num = stack.pop();
		if (stack.isEmpty()) {
			return num;
		} else {
			int foot = getFootNum(stack);
			stack.push(num);
			return foot;
		}
	}

	public int getMaxNum(int[] arr, int num) {
		Deque<Integer> qmax = new LinkedList<>();
		Deque<Integer> qmin = new LinkedList<>();
		int i = 0;
		int j = 0;
		int res = 0;
		while (i < arr.length) {
			while (j < arr.length) {
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
					break;
				}
				j++;
			}
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			res += j - i;
			i++;
		}
		return res;
	}

	public int maxLength(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int res = 0;
		int maxLen = 0;
		for (int i = 0; i != arr.length; i++) {
			res += arr[i];
			if (map.containsKey(res - k)) {
				maxLen = Math.max(maxLen, i - map.get(res - k));
			}
			if (!map.containsKey(res)) {
				map.put(res, i);
			}
		}
		return maxLen;
	}

	public int minPathSum(int[][] m) {
		if (m == null) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + m[0][i];
		}
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	public int minCoins1(int[] arr, int aim) {
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		int max = Integer.MAX_VALUE;
		for (int j = 1; j < aim + 1; j++) {
			dp[0][j] = max;
			if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < aim + 1; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	public int minCoins2(int[] arr, int aim) {
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		int max = Integer.MAX_VALUE;
		for (int j = 0; j < aim + 1; j++) {
			dp[0][j] = max;
		}
		if (arr[0] < aim) {
			dp[0][arr[0]] = 1;
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < aim + 1; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
					left = dp[i - 1][j - arr[0]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	public int coins3(int[] arr, int aim) {
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j * arr[0] < aim + 1; j++) {
			dp[0][j * arr[0]] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < aim + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
			}
		}
		return dp[n - 1][aim];
	}

	public int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	public int[] generateLIS(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				index = i;
				len = dp[i];
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if (dp[i] == len && arr[i] < arr[index]) {
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}

	public int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] end = new int[arr.length];
		int right = 0;
		end[0] = arr[0];
		dp[0] = 1;
		int l = 0;
		int m = 0;
		int r = 0;
		for (int i = 1; i < arr.length; i++) {
			l = 0;
			r = right;
			while (l <= r) {
				m = (l + r) / 2;
				if (end[m] < arr[i]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			end[l] = arr[i];
			right = Math.max(right, l);
			dp[i] = l + 1;
		}
		return dp;
	}

	public int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		for (int j = 1; j < str2.length; j++) {
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
				}
			}
		}
		return dp;
	}

	public String lcse(String str1, String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp(chs1, chs2);
		int m = chs1.length - 1;
		int n = chs2.length - 1;
		int index = dp[m][n];
		char[] res = new char[index--];
		while (index >= 0) {
			if (n > 0 & dp[m][n] == dp[m][n - 1]) {
				n--;
			} else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
				m--;
			} else {
				res[index--] = chs1[m];
				m--;
				n--;
			}
		}
		return res.toString();
	}

	public int[][] getdp3(char[] str1, char[] str2) {
		int m = str1.length;
		int n = str2.length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[m][0] = str1[m] == str2[0] ? 1 : 0;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = str1[0] == str2[j] ? 1 : 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = str1[i] == str2[j] ? dp[i - 1][j - 1] + 1 : 0;
			}
		}
		return dp;
	}

	public String lsct1(String str1, String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp3(chs1, chs2);
		int end = 0;
		int max = 0;
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j < chs2.length; j++) {
				if (max < dp[i][j]) {
					max = dp[i][j];
					end = i;
				}
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}

	public int minCost(String str1, String str2, int ic, int dc, int rc) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int m = chs1.length;
		int n = chs2.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			dp[m][0] = dc * i;
		}
		for (int j = 1; j < n + 1; j++) {
			dp[0][j] = ic * j;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (chs1[i - 1] == chs2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + rc;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
				dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
			}
		}
		return dp[m][n];
	}

	public boolean isCross1(String str1, String str2, String aim) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		char[] chaim = aim.toCharArray();
		int m = chs1.length;
		int n = chs2.length;
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i < m + 1; i++) {
			if (chs1[i - 1] != chaim[i - 1]) {
				break;
			}
			dp[i][0] = true;
		}
		for (int j = 1; j < n + 1; j++) {
			if (chs2[j - 1] != chaim[j - 1]) {
				break;
			}
			dp[0][j] = true;
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if ((dp[i - 1][j] && chs1[i - 1] == chaim[i + j - 1])
						|| (dp[i][j - 1] && chs2[j - 1] == chaim[i + j - 1])) {
					dp[i][j] = true;
				}
			}
		}
		return dp[m][n];
	}

	public int minHP(int[][] map) {
		int m = map.length;
		int n = map[0].length;
		int[][] dp = new int[m--][n--];
		dp[m - 1][n - 1] = Math.max(1 - map[m][n], 1);
		int left = 0;
		int right = 0;
		for (int i = m - 1; i >= 0; i--) {
			dp[i][n] = Math.max(dp[i + 1][n] - map[i][n], 1);
		}
		for (int j = n - 1; j >= 0; j--) {
			dp[m][j] = Math.max(dp[m][j + 1] - map[m][j], 1);
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				left = Math.max(1, dp[i][j + 1] - map[i][j]);
				right = Math.max(1, dp[i + 1][j] - map[i][j]);
				dp[i][j] = Math.min(left, right);
			}
		}
		return dp[0][0];
	}

	public int num1(String str1) {
		if (str1 == null) {
			return 0;
		}
		char[] chs1 = str1.toCharArray();
		return process(chs1, 0);
	}

	public int process(char[] chs, int i) {
		if (i == chs.length) {
			return 1;
		}
		if (chs[i] == '0') {
			return 0;
		}
		int res = process(chs, i + 1);
		if (i + 1 < chs.length && (chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
			res += process(chs, i + 2);
		}
		return res;
	}

	public int num2(String str1) {
		char[] chs1 = str1.toCharArray();
		int cur = chs1[chs1.length - 1] == '0' ? 0 : 1;
		int next = 1;
		int tmp = 0;
		for (int i = chs1.length - 2; i >= 0; i++) {
			if (chs1[i] == '0') {
				next = cur;
				cur = 0;
			} else {
				tmp = cur;
				if ((chs1[i] - '0') * 10 + chs1[i + 1] - '0' < 27) {
					cur += next;
				}
				next = tmp;
			}
		}
		return cur;
	}

	public int win1(int[] arr) {
		if (arr == null) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	public int f(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
	}

	public int s(int[] arr, int i, int j) {
		if (i == j) {
			return 0;
		}
		return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}

	public int win2(int[] arr) {
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for (int j = 0; j < arr.length; j++) {
			f[j][j] = arr[j];
			for (int i = j - 1; i >= 0; i--) {
				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}
		return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
	}

	public int jump(int[] arr) {
		int jump = 0;
		int next = 0;
		int cur = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (cur < i) {
				jump++;
				cur = next;
			}
			next = Math.max(next, arr[i] + i);
		}
		return jump;
	}

	public int longestConsecutive(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				if (map.containsKey(arr[i] - 1)) {
					max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
				}
				if (map.containsKey(arr[i] + 1)) {
					max = Math.max(max, merge(map, arr[i], arr[i] + 1));
				}
			}
		}
		return max;
	}

	public int merge(HashMap<Integer, Integer> map, int less, int more) {
		int left = less - map.get(less) + 1;
		int right = more + map.get(more) - 1;
		int len = right - left + 1;
		map.put(left, len);
		map.put(right, len);
		return right;
	}

	public int num1(int n) {
		int[] record = new int[n];
		return process1(0, record, n);
	}

	public int process1(int i, int[] record, int n) {
		if (i == n) {
			return 1;
		}
		int res = 0;
		for (int j = 0; j < record.length; j++) {
			if (isValid(record, i, j)) {
				record[i] = j;
				res += process1(i + 1, record, n);
			}
		}
		return res;
	}

	public boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}

	public int numSum(String str) {
		char[] chs = str.toCharArray();
		boolean flag = true;
		int res = 0;
		int num = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] < '0' || chs[i] > '9') {
				res += num;
				num = 0;
				if (chs[i] == '-') {
					flag = !flag;
				} else {
					flag = true;
				}
			} else {
				num = num * 10 + (flag ? chs[i] - '0' : '0' - chs[i]);
			}
		}
		res += num;
		return res;
	}

	public String removeKZeros(String str, int k) {
		char[] chs = str.toCharArray();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '0') {
				count++;
			} else {
				if (count != k) {
					while (count-- != 0) {
						sb.append('0');
					}
				}
				sb.append(chs[i]);
				count = 0;
			}
		}
		if (count != k) {
			while (count-- != 0) {
				sb.append('0');
			}
		}
		return sb.toString();
	}

	public boolean isValid1(char[] chs) {
		if (chs[0] == '-' && (chs.length == 1 || chs[1] == '0')) {
			return false;
		}
		if (chs[0] == '0' && chs.length > 1) {
			return false;
		}
		if (chs[0] != '-' && (chs[0] < '0' || chs[0] > '9')) {
			return false;
		}
		for (int i = 1; i < chs.length; i++) {
			if (chs[i] > '9' || chs[i] < '0') {
				return false;
			}
		}
		return true;

	}

	public int convert(String str) {
		char[] chs = str.toCharArray();
		if (!isValid1(chs)) {
			return 0;
		}

		boolean flag = chs[0] == '-' ? false : true;
		int num = 0;
		int res = 0;
		int mingq = Integer.MIN_VALUE / 10;
		int mingr = Integer.MIN_VALUE % 10;
		for (int i = 0; i < chs.length; i++) {
			num = '0' - chs[i];
			if (res < mingq || (res == mingq && num < mingr)) {
				return -1;
			}
			res = res * 10 + num;
		}
		if (flag && res == Integer.MIN_VALUE) {
			return -1;
		}
		return flag ? -res : res;

	}

	public String replace(String str, String from, String to) {
		char[] chs = str.toCharArray();
		char[] fchs = from.toCharArray();
		char[] tchs = to.toCharArray();
		int match = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == fchs[match]) {
				match++;
				if (match == fchs.length) {
					sb.append(to);
					match = 0;
				}
			} else {
				while (match != 0) {
					sb.append(chs[i - match]);
					match--;
				}
				match = 0;
				sb.append(chs[i]);
			}
		}
		return sb.toString();
	}

	public String getCountString(String str) {
		char[] chs = str.toCharArray();
		int num = 1;
		String res = String.valueOf(chs[0]);
		for (int i = 1; i < chs.length; i++) {
			if (chs[i] == chs[i - 1]) {
				num++;
			} else {
				res += "_" + num + "_" + chs[i];
				num = 1;
			}
		}
		res += "_" + num;
		return res;
	}

	public char getCharAt(String str, int k) {
		char[] chs = str.toCharArray();
		int num = 0;
		int res = 0;
		char cur = chs[0];
		boolean flag = true;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '_') {
				flag = !flag;
				res += num;
				if (flag && k <= res) {
					return cur;
				}
				num = 0;
			} else {
				if (!flag) {
					num = num * 10 + chs[i] - '0';
				} else {
					cur = chs[i];
				}
			}
		}
		res += num;
		return k <= res ? cur : 0;
	}

	public int getIndex(String[] strs, String str) {
		int l = 0;
		int r = strs.length - 1;
		int m = 0;
		int index = 0;
		int i = 0;
		while (l <= r) {
			m = (l + r) / 2;
			if (strs[m] == null) {
				i = m - 1;
				while (i >= 0 && strs[i--] == null) {
				}
				if (i < l || strs[i].compareTo(str) < 0) {
					l = m + 1;
				} else {
					index = strs[i].compareTo(str) == 0 ? i : index;
					r = i - 1;
				}
			} else if (strs[m].compareTo(str) < 0) {
				l = m + 1;
			} else {
				r = m - 1;
				index = strs[m].equals(str) ? m : index;
			}
		}
		return index;
	}

	public void modify(char[] chs) {
		int len = 0;
		int num = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == 0) {
				break;
			}
			if (chs[i] == ' ') {
				num++;
			}
			len++;
		}
		int j = len + num * 2 - 1;
		for (int i = len - 1; i >= 0; i--) {
			if (chs[i] == ' ') {
				chs[j--] = '0';
				chs[j--] = '2';
				chs[j--] = '%';
			} else {
				chs[j--] = chs[i];
			}
		}

	}

	public void replace(char[] chs) {
		int left = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '*') {
				swap(chs, left++, i);
			}
		}
	}

	public void rotateWord(char[] chs) {
		reverse(chs, 0, chs.length - 1);
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == ' ') {
				reverse(chs, index, i - 1);
				index = i + 1;
			}
		}
		reverse(chs, index, chs.length - 1);
	}

	public void reverse(char[] chs, int start, int end) {
		while (start < end) {
			swap(chs, start, end);
			start++;
			end--;
		}
	}

	public void rotate2(char[] chs, int size) {
		int start = 0;
		int end = chs.length - 1;
		int lpart = size;
		int rpart = chs.length - size;
		int s = Math.min(lpart, rpart);
		int d = lpart - rpart;
		while (true) {
			exchange(chs, start, end, s);
			if (d == 0) {
				break;
			} else if (d > 0) {
				lpart = d;
				start += rpart;
			} else {
				rpart = -d;
				end -= lpart;
			}
			d = lpart - rpart;
			s = Math.min(lpart, rpart);
		}
	}

	public int minDistance(String[] strs, String str1, String str2) {
		int last1 = -1;
		int last2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals(str1)) {
				min = Math.min(min, last2 == -1 ? min : i - last2);
				last1 = i;
			}
			if (strs[i].equals(str2)) {
				min = Math.min(min, last1 == -1 ? min : i - last1);
				last2 = i;
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public void exchange(char[] chs, int start, int end, int s) {
		int i = end - s + 1;
		while (s-- != 0) {
			swap(chs, start, i);
			start++;
			i++;
		}
	}

	public int[][] getDP(char[] str) {
		int[][] dp = new int[str.length][str.length];
		// for (int j = 1; j < dp.length; j++) {
		// dp[j-1][j] = str[j-1] == str[j]?0:1;
		// for (int i = j-2; i >=0; i--) {
		// if(str[i] == str[j]){
		// dp[i][j] = dp[i+1][j-1];
		// }else{
		// dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
		// }
		// }
		// }
		for (int i = dp.length - 2; i >= 0; i--) {
			dp[i][i + 1] = str[i] == str[i + 1] ? 0 : 1;
			for (int j = i + 1; j < dp.length; j++) {
				if (str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp;
	}

	public String getPalindromel(String str) {
		char[] chs = str.toCharArray();
		int[][] dp = getDP(chs);
		char[] res = new char[chs.length + dp[0][str.length() - 1]];
		int i = 0;
		int j = str.length() - 1;
		int resl = 0;
		int resr = res.length;
		while (i <= j) {
			if (chs[i] == chs[j]) {
				res[resl++] = chs[i++];
				res[resr--] = chs[j--];
			} else if (dp[i + 1][j] < dp[i][j - 1]) {
				res[resl++] = chs[i];
				res[resr--] = chs[i++];
			} else {
				res[resl++] = chs[j];
				res[resr--] = chs[j--];
			}
		}
		return String.valueOf(res);

	}

	public String getPalindromel(String str, String strlps) {
		char[] chs = str.toCharArray();
		char[] lps = strlps.toCharArray();
		char[] res = new char[2 * chs.length - lps.length];
		int chsl = 0;
		int chsr = chs.length - 1;
		int lpsl = 0;
		int lpsr = lps.length - 1;
		int resl = 0;
		int resr = res.length - 1;
		int tmpl = 0;
		int tmpr = 0;
		while (lpsl <= lpsr) {
			tmpl = chsl;
			tmpr = chsr;
			while (chs[chsl] != lps[lpsl]) {
				chsl++;
			}
			while (chs[chsr] != lps[lpsr]) {
				chsr--;
			}
			set(chs, tmpl, chsl, chsr, tmpr, res, resl, resr);
			resl += chsl - tmpl + tmpr - chsr;
			resr -= chsl - tmpl + tmpr - chsr;
			res[resl++] = lps[lpsl++];
			res[resr--] = lps[lpsr--];
			chsl++;
			chsr--;
		}
		return String.valueOf(res);
	}

	public void set(char[] chs, int lel, int ler, int ril, int rir, char[] res,
			int resl, int resr) {
		for (int i = lel; i < ler; i++) {
			res[resl++] = chs[i];
			res[resr--] = chs[i];
		}
		for (int i = rir; i > ril; i--) {
			res[resl++] = chs[i];
			res[resr--] = chs[i];
		}
	}

	public int maxLength(String str) {
		int[] dp = new int[str.length()];
		dp[0] = 0;
		char[] chs = str.toCharArray();
		int max = 0;
		for (int i = 1; i < str.length(); i++) {
			if (chs[i] == ')') {
				int pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chs[pre] == '(') {
					dp[i] = 2 + dp[i - 1] + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public void swap(char[] chs, int a, int b) {
		char tmp = chs[a];
		chs[a] = chs[b];
		chs[b] = tmp;
	}

	public int minUnique(String str) {
		char[] chs = str.toCharArray();
		int pre = -1;
		int min = Integer.MAX_VALUE;
		int[] map = new int[256];
		int cur = 0;
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		for (int i = 0; i < chs.length; i++) {
			pre = Math.max(pre, map[chs[i]]);
			cur = i - pre;
			min = Math.min(cur, min);
			map[chs[i]] = i;
		}
		return min;
	}

	public int minLength(String str1, String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int left = 0;
		int right = 0;
		int[] map = new int[256];
		int match = chs2.length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < chs2.length; i++) {
			map[chs2[i]]++;
		}
		while (right < chs1.length) {
			map[chs1[right]]--;
			if (map[chs1[right]] >= 0) {
				match--;
			}
			if (match == 0) {
				while (map[chs1[left]] < 0) {
					map[chs1[left++]]++;
				}
				min = Math.min(min, right - left + 1);
				map[chs1[left++]]++;
				match++;
			}
			right++;
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public int minCut(String str) {
		char[] chs = str.toCharArray();
		int len = chs.length;
		int[] dp = new int[len + 1];
		dp[len] = -1;
		boolean[][] p = new boolean[len + 1][len + 1];
		for (int i = len - 1; i >= 0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i; j < len; j++) {
				if (chs[i] == chs[j] && (j - i < 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
	}

	public boolean isValid(char[] s, char[] e) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '*' || s[i] == '.') {
				return false;
			}
		}
		for (int i = 0; i < e.length; i++) {
			if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
				return false;
			}
		}
		return true;
	}

	public boolean isMatch(String str1, String str2) {
		char[] s = str1.toCharArray();
		char[] e = str2.toCharArray();
		return process(s, e, 0, 0);
	}

	public boolean process(char[] s, char[] e, int si, int ei) {
		if (ei == e.length) {
			return si == s.length;
		}
		if (ei + 1 == e.length || e[ei + 1] != '*') {
			return si != s.length && (e[ei] == s[si] || e[ei] == '.')
					&& process(s, e, si + 1, ei + 1);
		}
		while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
			if (process(s, e, si + 1, ei + 2)) {
				return true;
			}
			si++;
		}
		return process(s, e, si, ei + 2);
	}

	public boolean isMatchDP(String str, String exp) {
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = initDPMap(s, e);
		for (int i = slen - 1; i >= 0; i--) {
			for (int j = elen - 1; j >= 0; j++) {
				if (e[j + 1] != '*') {
					dp[i][j] = (e[j] == s[i] || e[j] == '.')
							&& dp[i + 1][j + 1];
				} else {
					int si = i;
					while (si < slen && (e[j] == s[i] || e[j] == '.')) {
						if (dp[si][j + 2]) {
							dp[i][j] = true;
							break;
						}
					}
					if (!dp[i][j]) {
						dp[i][j] = dp[si][j + 2];
					}
				}
			}
		}
		return dp[0][0];
	}

	public boolean[][] initDPMap(char[] s, char[] e) {
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = new boolean[slen + 1][elen + 1];
		dp[slen][elen] = true;
		for (int j = elen - 1; j >= 0; j = j - 2) {
			if (e[j] != '*' && e[j + 1] == '*') {
				dp[slen][j] = true;
			}
		}
		if (e[elen - 1] == s[slen - 1] || e[elen] == '.') {
			dp[slen - 1][elen - 1] = true;
		}
		return dp;
	}

	public int maxUnique(String str) {
		char[] chs = str.toCharArray();
		int pre = -1;
		int[] map = new int[256];
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < chs.length; i++) {
			pre = Math.max(pre, map[chs[i]]);
			max = Math.max(max, i - pre);
			map[chs[i]] = i;
		}
		return max;
	}

	public int minLength1(String str1, String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int match = chs2.length;
		int[] map = new int[256];
		for (int i = 0; i < chs2.length; i++) {
			map[chs2[i]]++;
		}
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		while (right < chs1.length) {
			map[chs1[right]]--;
			if (map[chs1[right]] >= 0) {
				match--;
			}
			if (match == 0) {
				while (map[chs1[left]] < 0) {
					map[chs1[left++]]++;
				}
				min = Math.min(min, right - left + 1);
				match++;
				map[chs1[left++]]++;
			}
			right++;
		}
		return min;
	}

	public String longestPalindrome(String s) {
		char[] chs = s.toCharArray();
		int slen = chs.length;
		int maxLen = Integer.MIN_VALUE;
		String res = "";
		boolean[][] p = new boolean[slen][slen];
		for(int i = slen-1;i>=0;i--){
			for(int j = i;j<slen;j++){
				if (chs[i] == chs[j] && (j - i < 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					if (maxLen < j - i + 1) {
						maxLen = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Main1 m = new Main1();
		System.out.println(m.longestPalindrome("abacdfgdcaba"));

	}
}
