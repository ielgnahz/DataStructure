package sdu.edu.Structure.FifthStructure.Sort;

public class Test {

	public static void BubbleSort(int[] arr){
		int n = arr.length;
		for(int i = arr.length - 1;i >= 0;i--){
			for(int j = 0;j < i;j++){
				if(arr[j] > arr[j+1]){
					swap(arr, i, j);
				}
			}
		}
	}

	public static void SelectionSort(int[] arr){
		for(int i = 0;i < arr.length;i++){
			int min = i;
			for(int j = i+1;j < arr.length;j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			swap(arr,min,i);
		}
	}

	public static void InsertSort(int[] arr){
		for(int i = 1;i < arr.length;i++){
			int j = i - 1;
			int tmp = arr[i];
			while(j >= 0 && arr[j] > tmp){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = tmp;
		}
	}

	public static void MergeSort(int[] arr){
		int[] tmp = new int[arr.length];
		MergeSortRecursion(arr,0,arr.length - 1,tmp);
	}

	public static void MergeSortRecursion(int[] arr,int left,int right,int[] tmp){
		if(left >= right){
			return;
		}
		int mid = (left + right) / 2;
		MergeSortRecursion(arr, left,mid,tmp);
		MergeSortRecursion(arr, mid + 1, right, tmp);
		Merge(arr,left,mid,right,tmp);
	}

	public static void MergeSortInteration(int[] arr){
		int left = 0;
		int right = arr.length;
		int mid = 0;
		int[] tmp = new int[arr.length];
		for(int i = 1;i < arr.length;i = i * 2){
			left = 0;
			while(left + i < arr.length){
				mid = left + i - 1;
				right = mid + i < arr.length?mid + i:arr.length - 1;
				Merge(arr, left, mid, right, tmp);
				left = right + 1;
			}
		}
	}

	public static void Merge(int[] arr,int left,int mid,int right,int[] tmp){
		int i = left;
		int j = mid + 1;
		int index = left;
		while(i <= mid && j <= right){
			if(arr[i] < arr[j]){
				tmp[index++] = arr[i++];
			}else{
				tmp[index++] = arr[j++];
			}
		}
		while(i <= mid) {
			tmp[index++] = arr[i++];
		}

		while(j <= right){
			tmp[index++] = arr[j++];
		}

		while(left <= right){
			arr[left] = tmp[left++];
		}
	}

	public static void HeadSort(int[] arr){
		BuildHead(arr);
		int n = arr.length;
		while(--n > 0){
			swap(arr, n, 0);
			HeadSortRecursion(arr,0,n);
		}
	}

	public static void BuildHead(int[] arr){
		for(int i = arr.length / 2 - 1;i>=0;i--){
			HeadSortRecursion(arr,i,arr.length);
		}
	}

	public static void HeadSortRecursion(int[] arr,int i,int size){
		int k1 = 2 * i + 1;
		int k2 = 2 * i + 1;
		int max = i;
		if(k1 < size && arr[k1] > arr[max]){
			max = k1;
		}
		if(k2 < size && arr[k2] > arr[max]){
			max = k2;
		}
		if(max != i){
			swap(arr, i, max);
			HeadSortRecursion(arr, max, size);
		}
	}

	public static void HeadSortInteration(int[] arr,int i,int size){
		for(int k = 2 * i + 1;k < size ;k = 2 * k + 1){
			if(k + 1 < size && arr[k+1] > arr[k]){
				k = k+1;
			}
			if(arr[k] > arr[i]){
				swap(arr, k, i);
				k = i;
			}else{
				break;
			}
		}
	}

	public static void QuickSort(int[] arr,int left,int right){
		if(left >= right){
			return;
		}
		int pivot = Partition(arr,left,right);
		QuickSort(arr,left,pivot - 1);
		QuickSort(arr,pivot + 1,right);
	}

	public static int Partition(int[] arr,int left,int right){
		int tail = left;
		int cur = arr[right];
		while(left < right){
			if(cur > arr[left]){
				swap(arr, ++tail, left);
			}
			left++;
		}
		swap(arr,++tail, right);
		return tail;
	}



	public static void swap(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
	}
}
