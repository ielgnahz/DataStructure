package sdu.edu.Structure.ThirdStructure.test;

import sdu.edu.Structure.ThirdStructure.getPostArray.Node;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
	public int maxDistance(Node head) {
		int[] record = new int[1];
		return bs(head, record);
	}

	public int bs(Node head, int[] record) {
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		int lMax = bs(head.left, record);
		int maxfromLeft = record[0];
		int rMax = bs(head.right, record);
		int maxfromRight = record[0];
		int curNodemax = maxfromLeft + maxfromRight + 1;
		record[0] = Math.max(maxfromLeft, maxfromRight) + 1;
		return Math.max(Math.max(lMax, rMax), curNodemax);
	}

	public int minCoins(int[] arr, int aim) {
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = max;
			if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	public int minCoin2(int[] arr, int aim) {
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = max;
		}
		if (arr[0] < aim + 1) {
			dp[0][arr[0]] = 1;
		}
		int left = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
					left = dp[i - 1][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;

	}

	public int minCoin3(int[] arr, int aim) {
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j * arr[0] < aim + 1; j++) {
			dp[0][j * arr[0]] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < aim + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
			}
		}
		return dp[n - 1][aim];
	}

	public int[] getdp(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// for (int i = 0; i < dp.length; i++) {
		// System.out.print(dp[i]+" ");
		// }
		return dp;
	}

	public int[] generateLIS(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (len < dp[i]) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for (int i = index - 1; i >= 0; i--) {
			if (arr[i] < arr[index] && dp[index] == dp[i] + 1) {
				index = i;
				lis[--len] = arr[i];
			}
		}
		return lis;
	}

	public int[][] getdp(char[] str1, char[] str2) {
		int n = str1.length;
		int m = str2.length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < dp.length; i++) {
			if (str1[i] == str2[0]) {
				dp[i][0] = 1;
			}
		}
		for (int j = 0; j < dp[0].length; j++) {
			if (str1[0] == str2[j]) {
				dp[0][j] = 1;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				if (str1[i] == str2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}

		return dp;

	}

	public String getStr(String str1, String str2) {
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[][] dp = getdp(arr1, arr2);
		int max = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (dp[i][j] > max) {
					max = dp[i][j];
					index = j;
				}
			}
		}
		return str2.substring(index - max + 1, index + 1);

	}

	public int minCost(String str1, String str2, int ic, int rc, int dc) {
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int n = arr1.length;
		int m = arr2.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i * ic;
		}
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j * dc;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + rc;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
				dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
			}
		}
		return dp[n][m];
	}

	public int step(int[] arr) {
		int jump = 0;
		int cur = 0;
		int next = 0;
		for (int i = 0; i < arr.length; i++) {
			if (cur < i) {
				jump++;
				cur = next;
			}
			next = Math.max(next, i + arr[i]);
		}
		return jump;
	}

	public int longest(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}
			if (map.containsKey(arr[i] - 1)) {
				max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
			}
			if (map.containsKey(arr[i] + 1)) {
				max = Math.max(max, merge(map, arr[i], arr[i] + 1));
			}
		}
		return max;
	}

	public int merge(HashMap<Integer, Integer> map, int left, int right) {
		int less = left - map.get(left) + 1;
		int more = right - map.get(right) + 1;
		int len = more - less + 1;
		map.put(less, len);
		map.put(right, len);
		return len;
	}

	public int minDistance(String[] strs, String str1, String str2) {
		int last1 = -1;
		int last2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == str1) {
				min = Math.min(min, last2 == -1 ? min : i - last2);
				last1 = i;
			}
			if (strs[i] == str2) {
				min = Math.min(min, last1 == -1 ? min : i - last1);
				last2 = i;
			}
		}
		return min;
	}

	public int[][] getDP(char[] str) {
		int[][] dp = new int[str.length][str.length];
		for (int j = 1; j < dp.length; j++) {
			dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
			for (int i = j - 2; i >= 0; j--) {
				if (str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp;
	}

	public String getPalindromel(String str) {
		char[] chs = str.toCharArray();
		int[][] dp = getDP(chs);
		char[] res = new char[chs.length + dp[0][chs.length - 1]];
		int i = 0;
		int j = chs.length - 1;
		int resl = 0;
		int resr = res.length - 1;
		while (i <= j) {
			if (chs[i] == chs[j]) {
				res[resl++] = chs[i++];
				res[resr--] = chs[j--];
			} else if (dp[i][j - 1] < dp[i + 1][j]) {
				res[resl++] = chs[j];
				res[resr--] = chs[j--];
			} else {
				res[resl++] = chs[i];
				res[resr--] = chs[i++];
			}
		}
		return String.valueOf(res);
	}

	public int maxLength(String str) {
		char[] arr = str.toCharArray();
		int pre = 0;
		int len = 0;
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && arr[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			len = Math.max(len, dp[i]);
		}
		return len;
	}

	public int getValue(String str) {
		return value(str.toCharArray(), 0)[0];
	}

	public int[] value(char[] str, int i) {
		int pre = 0;
		int[] bra = new int[2];
		Deque<String> deq = new LinkedList<String>();
		while (i < str.length && str[i] != ')') {
			if (str[i] >= '0' && str[i] <= '9') {
				pre = pre * 10 + str[i++] - '0';
			} else if (str[i] != '(') {
				addNum(deq, pre);
				deq.addLast(str[i++] + "");
				pre = 0;
			} else {
				bra = value(str, i);
				pre = bra[0];
				i = bra[1] + 1;
			}
		}
		addNum(deq, pre);
		return new int[] { getNum(deq), i };
	}

	public int maxUnique(String str) {
		char[] arr = str.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		int pre = -1;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			pre = Math.max(pre, map[arr[i]]);
			len = Math.max(len, i - pre);
			map[arr[i]] = i;
		}
		return len;
	}

	public int minLength(String str1, String str2) {
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < arr2.length; i++) {
			map[arr2[i]]++;
		}
		int match = arr2.length;
		int left = 0;
		int right = 0;
		int minLen = 0;
		while(right != arr1.length){
			map[arr1[right]]--;
			if(map[arr1[right]] >=0){
				match--;
			}
			if(match == 0){
				while(map[arr1[left]] < 0){
					map[arr1[left++]]++;
				}
				minLen = Math.min(minLen, right - left + 1);
				match++;
				map[arr1[left++]]++;
			}
			right++;
		}
		return minLen;
	}
	
	public int minCut(String str){
		char[] arr = str.toCharArray();
		int len = arr.length;
		int[] dp = new int[len+1];
		boolean[][] p = new boolean[len][len];
		dp[len] = -1;
		for (int i = len-1; i >=0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i; j < len; j++) {
				if(arr[i] == arr[j] && (j-i < 2 || p[i+1][j-1])){
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j+1] + 1);
				}
			}
		}
		return dp[0];
	}

	public void addNum(Deque<String> deq, int pre) {
		if (!deq.isEmpty()) {
			String top = deq.pollLast();
			if (top.equals("+") || top.equals("-")) {
				deq.addLast(top);
			} else {
				int cur = Integer.valueOf(deq.pollLast());
				pre = top.equals("*") ? cur * pre : cur / pre;
			}
		}
		deq.addLast(pre + "");
	}

	public int getNum(Deque<String> deq) {
		int res = 0;
		int num = 0;
		boolean add = true;
		while (!deq.isEmpty()) {
			String str = deq.pollLast();
			if (str.equals("+")) {
				add = true;
			} else if (str.equals("-")) {
				add = false;
			} else {
				num = Integer.valueOf(str);
				res += add ? num : (-num);
			}
		}
		return res;
	}
	
	public void spiralOrder(int[][] matrix){
		int tR = 0;
		int tC = 0;
		int dR = matrix.length-1;
		int dC = matrix[0].length;
		while(tR <= dR && tC <= dC){
			printEdge(matrix,tR++,tC++,dR--,dC--);
		}
	}
	public void printEdge(int[][] matrix,int tR,int tC,int dR,int dC){
		if(tR == dR){
			for (int i = 0; i < dC; i++) {
				System.out.print(matrix[dR][i]+" ");
			}
		}else if(tC == dC){
			for (int j = 0; j < dR; j++) {
				System.out.print(matrix[j][tC] + " ");
			}
		}else{
			int curR = tR;
			int curC = tC;
			while(curC != dC){
				System.out.println(matrix[tR][curC]+" ");
				curC++;
			}
			while(curR != dR){
				System.out.print(matrix[curR][dC]+" ");
				curR++;
			}
			while(curC != tC){
				System.out.println(matrix[dR][curC]+" ");
				curC--;
			}
			while(curR != tR){
				System.out.println(matrix[curR][tC]+" ");
				curR--;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		int[] dp = new Main().getdp(a);
		int[] lis = new Main().generateLIS(a, dp);
		for (int i = 0; i < lis.length; i++) {
			System.out.print(lis[i] + " ");
		}
	}
}
