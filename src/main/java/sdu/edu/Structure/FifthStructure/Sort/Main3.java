package sdu.edu.Structure.FifthStructure.Sort;

public class Main3 {

    public void BubbleSort(int[] arr){
        for(int i = arr.length-1;i>=0;i--){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void InsertSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int min = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > min){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = min;
        }
    }

    public void SelectionSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            int min = i;
            for(int j = i;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public void MergeSortRecursion(int[] arr,int left,int right,int[] tmp){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        MergeSortRecursion(arr, left, mid,tmp);
        MergeSortRecursion(arr, mid+1, right,tmp);
        MergeSort(arr,left,mid,right,tmp);
    }

    public void MergeSort(int[] arr,int left,int mid,int right,int[] tmp){
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
        while(i <= mid){
            tmp[index++] = arr[i++];
        }
        while(j <= right){
            tmp[index++] = arr[j++];
        }
        while(left <= right){
            arr[left] = tmp[left++];
        }
    }

    public void MergeSortInteraction(int[] arr){
        int left = 0;
        int right = arr.length;
        int mid = 0;
        int[] tmp = new int[arr.length];
        for(int i = 1;i < arr.length;i *= 2){
            left = 0;
            while(left + i < arr.length){
                mid  = left + i- 1;
                right = mid + i >= arr.length?arr.length-1:mid+i;
                MergeSort(arr, left, mid, right, tmp);
                left = right + 1;
            }
        }
    }

    public void HeadSort(int[] arr){
        int n =arr.length;
        BuildHead(arr);
        while(n > 0){
            swap(arr, 0, --n);
            HeadSortInteraction(arr, 0, n);
        }
    }

    public void BuildHead(int[] arr){
        for(int i = arr.length / 2 - 1;i>=0;i--){
            HeadSortInteraction(arr, i, arr.length);
        }
    }

    public void HeadSortRecursion(int[] arr,int k,int size){
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        int max = k;
        if(left < size && arr[left] > arr[k]){
            k = left;
        }
        if(right < size && arr[right] > arr[k]){
            k = right;
        }
        if(max != k){
            swap(arr, k, max);
            HeadSortRecursion(arr, max, size);
        }
    }

    public void HeadSortInteraction(int[] arr,int k,int size){
        for(int i = 2 * k + 1;i < size;i = i * 2 + 1){
            if(i + 1 < size && arr[i] < arr[i+1]){
                i = i+1;
            }
            if(arr[k] < arr[i]){
                swap(arr, k, i);
                k = i;
            }else{
                break;
            }
        }
    }

    public void QuickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int pivot = Partation(arr,left,right);
        QuickSort(arr, left, pivot-1);
        QuickSort(arr, pivot+1, right);
    }

    public int Partation(int[] arr,int start,int right){
        int tail = start - 1;
        for(int i = start;i < right;i++){
            if(arr[i] < arr[right]){
                swap(arr, i, ++tail);
            }
        }
        swap(arr, right, ++tail);
        return tail;
    }



    public void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        new Main3().QuickSort(arr,0,arr.length - 1);
//        new Main3().MergeSortRecursion(arr, 0, arr.length-1, new int[arr.length]);
        for (int i :
                arr) {
            System.out.print(i+" ");
        }
    }
}
