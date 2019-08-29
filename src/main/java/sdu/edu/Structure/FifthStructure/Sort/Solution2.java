package sdu.edu.Structure.FifthStructure.Sort;

import java.util.ArrayList;

public class Solution2 {
	public int NumberOf1Between1AndN_Solution(int n) {
		int len = getLenOfNum(n);
		if (len == 1) {
			return 1;
		}
		int tmp = (int) Math.pow(10, len - 1);
		int first = n / tmp;
		int firstNum = first == 1 ? n % tmp + 1 : tmp;
		int secondNum = first * (len - 1) * (tmp / 10);
		return firstNum + secondNum + NumberOf1Between1AndN_Solution(n % tmp);
	}

	public int getLenOfNum(int n) {
		int num = 1;
		while (n / 10 != 0) {
			num++;
			n = n / 10;
		}
		return num;
	}

	public static int FirstNotRepeatingChar(String str) {
		int[] map = new int[256];
		char[] strs = str.toCharArray();
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		for (int i = 0; i < strs.length; i++) {
			if (map[strs[i]] == -1) {
				map[strs[i]] = i;
			} else {
				map[strs[i]] = -2;
			}
		}
		for (int i = 0; i < strs.length; i++) {
			if (map[strs[i]] != -2) {
				return map[strs[i]];
			}
		}
		return -1;
	}

	public static int InversePairs(int[] array) {
		int[] tmp = new int[array.length];
		int count = InversePairs(array, tmp, 0, array.length - 1);
		return count % 1000000007;
	}

	public static int InversePairs(int[] array, int[] tmp, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int len = (end - start) / 2;
		int left = InversePairs(array, tmp, start, start + len);
		int right = InversePairs(array, tmp, start + len + 1, end);
		int count = 0;
		int i = start + len;
		int j = end;
		int index = end;
		while (i >= start && j >= start + len + 1) {
			if (array[i] > array[j]) {
				tmp[index--] = array[i--];
				count += j - len - start;
				if (count >= 1000000007) {
					count %= 1000000007;
				}
			} else {
				tmp[index--] = array[j--];
			}
		}
		while (i >= start) {
			tmp[index--] = array[i--];
		}
		while (j >= start + len + 1) {
			tmp[index--] = array[j--];
		}
		index = 0;

		while (start <= end) {
			array[start] = tmp[start++];
		}
		return (left + right + count) % 1000000007;
	}

	/*
	 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
	 */

	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length == 0) {
			return;
		}
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			num ^= array[i];
		}
		int len = getRight1(num);
		ArrayList<Integer> list0 = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (isZero(array[i], len)) {
				list0.add(array[i]);
			} else {
				list1.add(array[i]);
			}
		}
		for (Integer i : list0) {
			num1[0] ^= i;
		}
		for (Integer i : list1) {
			num2[0] ^= i;
		}
	}

	public static int getRight1(int num) {
		int count = 0;
		while ((num & 1) != 1) {
			count++;
			num = num >> 1;
		}
		return count;
	}

	public static boolean isZero(int num, int len) {
		num = num >> len;
		return (num & 1) != 1;
	}

	public static int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int first = getFirstK(array, k, 0, array.length - 1);
		int last = getLastK(array, k, 0, array.length - 1);
		System.out.println(first);
		System.out.println(last);
		if (first != -1 && last != -1) {
			return last - first + 1;
		}
		return 0;
	}

	public static int getFirstK(int[] array, int k, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] < k) {
				left = mid + 1;
			} else if (array[mid] > k) {
				right = mid - 1;
			} else {
				if (mid == 0 || array[mid] != array[mid - 1]) {
					return mid;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static int getLastK(int[] array, int k, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] < k) {
				left = mid + 1;
			} else if (array[mid] > k) {
				right = mid - 1;
			} else {
				if (mid == array.length || array[mid] != array[mid + 1]) {
					return mid;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}

	/*
	 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
	 * 他在想究竟有多少种连续的正数序列的和为100
	 * (至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你
	 * ,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
	 */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		int left = 1;
		int right = 2;
		int len = (sum + 1) / 2;
		int curSum = 3;
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		while (right <= len) {
			if (curSum < sum) {
				right++;
				if (right == len + 1) {
					break;
				}
				curSum += right;
			} else if (curSum > sum) {
				curSum -= left;
				left++;
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = left; i <= right; i++) {
					list.add(i);
				}
				result.add(list);
				curSum -= left;
				left++;
			}
		}
		return result;
	}

	/*
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
	 */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		if (array == null || array.length == 0) {
			return new ArrayList<>();
		}
		int left = 0;
		int right = array.length - 1;
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (left < right) {
			if (array[left] + array[right] < sum) {
				left++;
			} else if (array[left] + array[right] > sum) {
				right--;
			} else {
				flag = true;
				break;
			}
		}
		if (flag) {
			list.add(array[left]);
			list.add(array[right]);
		}
		return list;
	}

	/*
	 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
	 * 请你把其循环左移K位后的序列输出
	 * 。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
	 */
	public String LeftRotateString(String str, int n) {
		if (str == null || str.equals("")) {
			return "";
		}
		char[] strs = str.toCharArray();
		reverse(strs, 0, n - 1);
		reverse(strs, n, strs.length - 1);
		reverse(strs, 0, strs.length - 1);
		return String.valueOf(strs);
	}

	public void reverse(char[] strs, int start, int end) {
		char tmp = ' ';
		while (start < end) {
			tmp = strs[end];
			strs[end] = strs[start];
			strs[start] = tmp;
			start++;
			end--;
		}
	}

	/*
	 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
	 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a
	 * student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
	 */
	public String ReverseSentence(String str) {
		char[] strs = str.toCharArray();
		reverse(strs, 0, strs.length - 1);
		int left = -1;
		int right = -1;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i] != ' ') {
				left = i == 0 || strs[i - 1] == ' ' ? i : left;
				right = i == strs.length - 1 || strs[i + 1] == ' ' ? i : right;
			}
			if (left != -1 && right != -1) {
				reverse(strs, left, right);
				left = -1;
				right = -1;
			}
		}
		return String.valueOf(strs);
	}

	/*
	 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气
	 * ,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My
	 * God!”不是顺子.....LL不高兴了,他想了想,决定大\小
	 * 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So
	 * Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
	 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
	 */
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return false;
		}
		QuickSort(numbers, 0, numbers.length - 1);
		int numOfZero = 0;
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			numOfZero++;
		}
		int small = numOfZero;
		int big = small + 1;
		int numOfSpace = 0;
		while (big < numbers.length) {
			if (numbers[small] == numbers[big]) {
				return false;
			}
			numOfSpace += numbers[big] - numbers[small] - 1;
			small++;
			big++;
		}
		return numOfSpace <= numOfZero;
	}

	public void QuickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = Partition(arr, start, end);
		QuickSort(arr, start, pivot - 1);
		QuickSort(arr, pivot + 1, end);
	}

	public int Partition(int[] arr, int start, int end) {
		int tail = start - 1;
		int pivot = arr[end];
		for (int i = start; i <= end; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, ++tail);
			}
		}
		swap(arr, end, ++tail);
		return tail;
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/*
	 * 
	 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先
	 * ,
	 * 让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物
	 * ,
	 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“
	 * 名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
	 */
	public int LastRemaining_Solution(int n, int m) {
		if (n == 0) {
			return -1;
		}
		if (n == 1) {
			return 0;
		}
		return (LastRemaining_Solution(n - 1, m) + m) % n;
	}

	/*
	 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 */

	public static int plus(int sum, int n) {
		boolean is_end = true;
		sum += n;
		is_end = (n > 0) && ((sum = plus(sum, --n)) > 0);
		return sum;
	}

	public static int plus(int n) {
		try {
			int[] m = new int[n - 2];
		} catch (Exception e) {
			return 1;
		}
		return n + plus(n - 1);
	}

	/*
	 * public int Sum_Solution(int n) { try{ int[] m = new int[n-2];
	 * }catch(Exception e){ return 1; } return n + Sum_Solution(n-1); }
	 */
	/*
	 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
	 */
	public int Add(int num1, int num2) {
		int res = num1;
		while (num2 != 0) {
			res = num1;
			num1 = num1 ^ num2;
			num2 = (res & num2) << 1;
			System.out.println("num1=" + num1);
			System.out.println("num2=" + num2);
		}
		return num1;
	}

	/*
	 * 
	 * public int Add(int num1,int num2) { 
	 * if(num2 == 0){ 
	 * return num1; 
	 * } 
	 * return Add(num1^num2,(num1&num2)<<1); 
	 * }
	 */

	/*
	 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
	 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
	 */

	public int StrToInt(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] strs = str.toCharArray();
		if (!isValid(strs)) {
			return 0;
		}
		int minl = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		int res = 0;
		int cur = 0;
		boolean flag = strs[0] == '-' ? true : false;
		for (int i = strs[0] == '-' || strs[0] == '+' ? 1 : 0; i < strs.length; i++) {
			cur = '0' - strs[i];
			if (res < minl || (res == minl && cur < minr)) {
				return 0;
			}
			res = res * 10 + cur;
		}
		if (!flag && res == Integer.MIN_VALUE) {
			return 0;
		}
		return flag ? res : -res;
	}

	public boolean isValid(char[] strs) {
		if (strs[0] != '-' && strs[0] != '+'
				&& (strs[0] > '9' && strs[0] < '0')) {
			return false;
		}
		if ((strs[0] == '-' || strs[0] == '+')
				&& (strs.length == 1 || strs[1] == '0')) {
			return false;
		}
		if (strs[0] == '0' && strs.length > 1) {
			return false;
		}
		for (int i = 1; i < strs.length; i++) {
			if (strs[i] < '0' || strs[i] > '9') {
				return false;
			}
		}
		return true;
	}

	/*
	 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
	 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
	 */
	public boolean duplicate(int arr[], int length, int[] duplication) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int i = 0;
		while (i < length) {
			if (arr[i] != i) {
				if (arr[i] != arr[arr[i]]) {
					swap(arr, arr[i], i);
				} else {
					duplication[0] = arr[i];
					return true;
				}
			} else {
				i++;
			}
		}
		return false;
	}

	/*
	 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1
	 * ]*A[i+1]*...*A[n-1]。不能使用除法。
	 */
	public int[] multiply(int[] A) {
        if(A == null || A.length == 0){
            return null;
        }
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        B[0] = 1;
        C[A.length-1] = 1;
        for(int i = 1;i<A.length;i++){
            B[i] = A[i-1] * B[i-1];
        }
        for(int i = A.length-2;i>=0;i--){
            C[i] = C[i+1] * A[i+1];
            B[i] = B[i] * C[i];
        }
        return B;
    }
	

	public static void main(String[] args) {
//		System.out.println(new Solution2().Add(1, 3));
//		String s = "";
//		System.out.println(s.toCharArray()[0] == '\0');
//		System.out.println(match("".toCharArray(), ".*".toCharArray()));;
		System.out.println(isNumeric("12e".toCharArray()));
		// int[] a = new int[] { 1,2,3,3,3,3,4,5 };
		// System.out.println(GetNumberOfK(a, 3));
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i]+" ");
		// }
		// int[] num1 = new int[1];
		// int[] num2 = new int[1];
		// FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, num1, num2);
		// System.out.println("num1[0]="+num1[0]+",num2[0]="+num2[0]);
	}
	
    public static boolean isNumeric(char[] str) {
        if(str == null){
            return false;
        }
        int index = 0;
        int before = index;
        if(str[index ]== '-' || str[index] == '+'){
            index++;
        }
        before = index;
        while(index < str.length && (str[index]<='9' && str[index] >='0')){
            index++;
        }
        boolean flag = index>before;
        if(index < str.length && str[index] == '.'){
            index++;
            before = index;
            while(index < str.length && (str[index]<='9' && str[index] >='0')){
            index++;
            }
            flag = flag || (index>before);
        }
        if(index < str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            if(index < str.length && (str[index] == '+' || str[index] == '-')){
                index++;
            }
            before = index;
            while(index < str.length && (str[index]<='9' && str[index] >='0')){
            index++;
            }
            flag = flag && (index > before);
        }
        return flag && index == str.length;
    }
	
	public static boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false;
        }
        return match(str,0,pattern,0);
    }
    public static boolean match(char[] a,int i,char[] b,int j){
        if(i == a.length && j == b.length){
            return true;
        }
        if(i != a.length && j == b.length){
            return false;
        }
        if(j+1 < b.length && b[j+1] == '*'){
            if(a[i] == b[j] || (b[j] == '.' && i<a.length)){
                return match(a,i+1,b,j+2) || match(a,i+1,b,j) || match(a,i,b,j+2);
            }else{
                return match(a,i,b,j+2);
            }
        }
        if(a[i] == b[j] || (b[j] =='.' && i<a.length)){
            return match(a,i+1,b,j+1);
        }
        return false;
    }

}
