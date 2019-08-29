package sdu.edu.Structure.FifthStructure.Sort;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class Main1 {
	public static void BubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}

	}

	public static void CocktailSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			for (int i = left; i < right; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
			right--;
			for (int i = right; i > left; i--) {
				if (arr[i] < arr[i - 1]) {
					swap(arr, i, i - 1);
				}
			}
			left++;
		}
	}

	public static void SelectionSort(int[] arr) {
		int n = arr.length;
		int min = 0;
		for (int i = 0; i < n - 1; i++) {
			min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = j;
				}
			}
			swap(arr, min, i);
		}
	}

	public static void InsertSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && cur < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = cur;
		}
	}

	public static void InsertSortDichotomy(int[] arr) {
		int n = arr.length;
		int left = 0;
		int right = 0;
		int mid = 0;
		int cur = 0;
		for (int i = 1; i < n; i++) {
			cur = arr[i];
			left = 0;
			right = i - 1;
			mid = (left + right) / 2;
			while (left <= right) {
				if (cur < arr[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				arr[j + 1] = arr[j];
			}
			arr[left] = cur;
		}
	}

	public void ShellSort(int[] arr) {
		int n = arr.length;
		int h = 0;
		while (h < arr.length){
			h = h * 3 + 1;
		}
		while (h < 0) {
			for (int i = h; i < n; i++) {
				int cur = arr[i];
				int j = i - h;
				while (j >= 0 && cur < arr[j]) {
					arr[j + h] = arr[j];
				}
				arr[j + h] = cur;
			}
			h = (h - 1) / 3;
		}
	}
	public static void MergeSortRecursion(int[] arr){
		int[] tmp = new int[arr.length];
		MergeSortRecursion(arr, 0, arr.length-1, tmp);
	}

	public static void MergeSortRecursion(int[] arr, int left, int right,int[] tmp) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		MergeSortRecursion(arr, left, mid,tmp);
		MergeSortRecursion(arr, mid + 1, right,tmp);
		Merge(arr, left, mid, right,tmp);
	}

	public static void Merge(int[] arr, int left, int mid, int right,int[] tmp) {
		int i = left;
		int j = mid + 1;
		int len = right - left + 1;
		int m = left;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				tmp[m++] = arr[i++];
			} else {
				tmp[m++] = arr[j++];
			}
		}
		while (i <= mid) {
			tmp[m++] = arr[i++];
		}
		while (j <= right) {
			tmp[m++] = arr[j++];
		}
		for (int k = 0; k < len; k++) {
			arr[left] = tmp[left++];
		}
	}

	public static void MergeSortInteration(int[] arr) {
		int n = arr.length;
		int[] tmp = new int[n];
		int left = 0;
		int mid = 0;
		int right = 0;
		for (int i = 1; i < n; i = i * 2) {
			left = 0;
			while (left + i < arr.length) {
				mid = left + i - 1;
				right = mid + i > arr.length ? arr.length - 1 : mid + i;
				Merge(arr, left, mid, right,tmp);
				left = right + 1;
			}
		}
	}

	public static void HeapSort(int[] arr) {
		BuildHeap(arr);
		int n = arr.length;
		while (n > 1) {
			swap(arr, 0, --n);
			// HeapRecursion(arr, 0, n);
			HeapInteration(arr, 0, n);
		}
	}

	public static void BuildHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			// HeapRecursion(arr, i, arr.length);
			HeapInteration(arr, i, arr.length);
		}
	}

	public static void HeapRecursion(int[] arr, int i, int size) {
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
			HeapRecursion(arr, max, size);
		}
	}

	public static void HeapInteration(int[] arr, int i, int size) {
		for (int k = i * 2 + 1; k < size; k = k * 2 + 1) {
			if (k + 1 < size && arr[k + 1] > arr[k]) {
				k = k + 1;
			}
			int tmp = arr[i];
			if (arr[k] > tmp) {
				arr[i] = arr[k];
				i = k;
				arr[k] = tmp;
			} else {
				break;
			}
		}
	}

	public static void QuickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = Partition(arr, left, right);
		QuickSort(arr, left, pivot - 1);
		QuickSort(arr, pivot + 1, right);
	}

    public static int Partition(int[] arr,int start,int end){
        int left = start - 1;
        int k = randomRange(start,end);
        swap(arr, end, k);
        for(int i = start;i<end;i++){
            if(arr[i] <= arr[end]){
                swap(arr,i,++left);
            }
        }
        swap(arr,end,++left);
        return left;
    }
    public static int randomRange(int min,int max){
        Random random = new Random();
        return random.nextInt(max - min + 1)  + min;
    }
    
//	public static int Partition(int[] arr, int left, int right) {
//		int pivot = arr[right];
//		int tail = left - 1;
//		for (int i = left; i < right; i++) {
//			if(arr[i] <= pivot){
//				swap(arr, ++tail, i);
//			}
//		}
//		swap(arr, ++tail, right);
//		return tail;
//	}
	/**
	 * 桶排序
	 * 时间复杂度 O(n * log n/m ),m为桶的个数当桶的个数接近数据的个数时，logn/m是一个非常小的数
	 * 空间复杂度 O(m)
	 *
	 * 适用条件
	 * 首先，要排序的数据需要很容易就能划分为  m 个桶，并且桶与桶之间有着天然的大小顺序。
	 * 其次，数据在各个桶之间的分布是比较均匀的。
	 * 桶排序比较适合用在外部排序中。所谓的外部排序就是数据存储在外部磁盘中，数据比较大而内存有限，无法将数据全部加载到内存中去。
	 */

	/**
	 * 计数排序
	 * 时间复杂度：O(n + k) k 为最大值数据的位数
	 * 空间复杂度：O(n + k)
	 * 对每一个输入元素，计算小于它的元素个数，如果有10个元素小于它，那么它就应该放在11的位置上，如果有17个元素小于它，它就应该放在18的位置上。
	 * 计数排序只适用于数据范围不大的场景中，如果数据范围  K 比排序的数据 n 大很多，就不适合用计数排序了。
	 *
	 * @param arr
	 * @return
	 */

	public int[] CountSort1(int[] arr){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[] B = new int[arr.length];
		for(int i = 0;i < arr.length;i++){
			if(arr[i] > max){
				max = arr[i];
			}
			if(arr[i] < min){
				min = arr[i];
			}
		}
		int[] A = new int[max - min + 1];

		for(int i = 0;i < arr.length;i++){
			A[arr[i] - min]++;
		}

		for(int i = 1;i < A.length;i++){
			A[i] += A[i-1];
		}

		for(int i = arr.length - 1;i >= 0;i--){
			B[--A[arr[i] - min]] = arr[i];
		}
		return B;
	}

	/**
	 * 基数排序，基数指10 100 1000这种
	 * 时间复杂度：O(k * n) k为最大值数据的位数
	 * 空间复杂度：O(k + n)
	 *
	 * @param arr
	 */
	private int dn = 3;
	private int k = 10;
	private int[] C = new int[10];
	int[] radix = {1,1,10,100};

	private int GetDigit(int x,int d){
		return (x / radix[d]) % 10;
	}

	private void RadixSort(int[] arr){
		for(int d = 1;d <= dn;d++){
			RadixSort(arr, d);
		}
	}

	private void RadixSort(int[] arr,int d){
		Arrays.fill(C, 0);
		for(int i = 0;i < arr.length;i++){
			C[GetDigit(arr[i],d)]++;
		}
		for(int i = 1;i < k;i++){
			C[i] += C[i-1];
		}

		int[] B = new int[arr.length];
		for(int i = arr.length-1;i >= 0;i--){
			int digit = GetDigit(arr[i],d);
			B[--C[digit]] = arr[i];
		}
		for(int i = 0;i < arr.length;i++){
			arr[i] = B[i];
		}
	}

	

	public static void main(String[] args) {

//		Random random = new Random(10);
//		System.out.println(new BigDecimal(random.doubles(0.6, 0.7).limit(1).findFirst().getAsDouble()).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());

		System.out.println(new BigDecimal(new Random("brand_word_100004".hashCode()).doubles(0.6, 0.7).skip(1).limit(1).findFirst().getAsDouble()).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
//        List<String> list = new ArrayList<>();
//        Collections.swap(list, 1, 2);

//		List<Integer> list = new ArrayList(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);}};
//		Random random = new Random(10);
//		for(int i = 0;i < 10;i++){
//			System.out.println(list.get(random.nextInt(list.size())));
//		}



//		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		// InsertSort(arr);
		// MergeSortRecursion(arr, 0, arr.length-1);
		// MergeSortInteration(arr);
//		HeapSort(arr);
//		 QuickSort(arr, 0, arr.length - 1);

//		MergeSortRecursion(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		arr = new Main1().CountSort1(arr);
//		for(int a : arr){
//			System.out.print(a+" ");
//		}

//		int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
//		new Main1().RadixSort(arr);
//		for (int i :
//				arr) {
//			System.out.print(i+" ");
//		}
	}

	public static void swap(int[] arr, int m, int n) {
		int tmp = arr[m];
		arr[m] = arr[n];
		arr[n] = tmp;
	}
}
