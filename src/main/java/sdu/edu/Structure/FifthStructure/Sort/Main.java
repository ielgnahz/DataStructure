package sdu.edu.Structure.FifthStructure.Sort;

public class Main {
	public static void BubbleSort(int[] arr){
		int len = arr.length;
		for(int i = len - 1;i >= 0;i--){
			for(int j = 0; j < i;j++){
				if(arr[j] > arr[j + 1]){
					swap(arr, j, j+1);
				}
			}
		}
	}

	public static void SelectSort(int[] arr){
		for(int i = 0;i < arr.length;i++){
			int min = i;
			for(int j = i + 1;j < arr.length;j++){
				if(arr[min] > arr[j]){
					min = j;
				}
			}
			swap(arr, min, i);
		}
	}

	public static void InsertSort(int[] arr){
		for(int i = 1;i < arr.length;i++){
			int j = i - 1;
			int val = arr[i];
			while(j >= 0 && val < arr[j]){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = val;
		}
	}

	public static void ShellSort(int[] arr){
		int h = 1;
		int len = arr.length;
		while(h <= len){
			h = h * 3 + 1;
		}
		while(h >= 1){
			for(int i = h;i < arr.length;i += h){
				int j = i - h;
				int val = arr[i];
				while(j >= 0 && arr[j] > val ){
					arr[j + h]= arr[j];
					j -= h;
				}
				arr[j+h] = val;
			}
			h = (h - 1) / 3;
		}
	}

	public static void MergeSortRecursion(int[] arr){
		int[] tmp = new int[arr.length];
		MergeSortRecursion(arr,0,arr.length-1,tmp);
	}

	public static void MergeSortRecursion(int[] arr,int left,int right,int[] tmp){
		if(left >= right){
			return;
		}
		int mid = (left + right) / 2;
		MergeSortRecursion(arr,left,mid,tmp);
		MergeSortRecursion(arr, mid+1, right, tmp);
		Merge(arr,left,mid,right,tmp);
	}

	public static void Merge(int[] arr,int left,int mid,int right,int[] tmp){
		int k = left;
		int i = left;
		int j = mid + 1;
		while(i <= mid && j <= right){
			if(arr[i] < arr[j]){
				tmp[k++] = arr[i++];
			}else{
				tmp[k++] = arr[j++];
			}
		}
		while(i <= mid){
			tmp[k++] = arr[i++];
		}
		while(j <= right){
			tmp[k++] = arr[j++];
		}
		while(left <= right){
			arr[left] = tmp[left++];
		}
	}

	public static void MergeSortInteration(int[] arr){
		int left = 0;
		int right = 0;
		int mid = 0;
		int[] tmp= new int[arr.length];
		for(int i =1;i < arr.length;i = i * 2){
			left = 0;
			while(left + i <= arr.length){
				mid = left + i - 1;
				right = mid + i < arr.length?mid + i:arr.length-1;
				Merge(arr, left, mid, right, tmp);
				left = right + 1;
			}
		}
	}

	public static void HeadSortByRecursion(int[] arr){
		BuildHeadRecursion(arr);
		int n = arr.length;
		while(--n > 0){
			swap(arr, 0, n);
			HeadRecursion(arr, 0, n);
		}
	}

	public static void BuildHeadRecursion(int[] arr){
		for(int i = arr.length/2 - 1;i >=0;i--){
			HeadRecursion(arr,i,arr.length);
		}
	}

	public static void HeadRecursion(int[] arr,int i,int size){
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if(left < size && arr[left] > arr[max]){
			max = left;
		}
		if(right < size && arr[right] > arr[max]){
			max = right;
		}
		if(max != i){
			swap(arr, max,i);
			HeadRecursion(arr, max, size);
		}
	}

	public static void HeadSortByInteration(int[] arr){
		BuildHeadInteration(arr);
		int n = arr.length;
		while(--n > 0){
			swap(arr, 0, n);
			HeadInteration(arr, 0, n);
		}
	}

	public static void BuildHeadInteration(int[] arr){
		for(int i = arr.length / 2 - 1;i >= 0;i--){
			HeadInteration(arr,i,arr.length);
		}
	}

	public static void HeadInteration(int[] arr,int i,int size){
		for(int k = 2 * i + 1;k < size ;k = 2 * k + 1){
			if(k + 1 < size && arr[k] < arr[k+1]){
				k = k+1;
			}
			if(arr[i] < arr[k]){
				swap(arr, i, k);
				i = k;
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
		QuickSort(arr, left, pivot-1);
		QuickSort(arr, pivot+1, right);
	}

	public static int Partition(int[] arr,int left,int right){
		int tail = left - 1;
		int cur = arr[right];
		while(left < right){
			if(cur > arr[left]){
				swap(arr, left, ++tail);
			}
			left++;
		}
		swap(arr, ++tail, right);
		return tail;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
		Main.QuickSort(arr,0,arr.length-1);
		my:for(int i : arr){
			System.out.print(i + " ");
			break my;
		}
	}

	public static void swap(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
