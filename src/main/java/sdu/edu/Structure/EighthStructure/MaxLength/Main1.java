package sdu.edu.Structure.EighthStructure.MaxLength;

public class Main1 {
	// public void maxLength(int[] arr,int k){
	// HashMap<Integer, Integer> map = new HashMap<>();
	// map.put(0, -1);
	// int len = 0;
	// int sum = 0;
	// for (int i = 0; i < arr.length; i++) {
	// sum+=arr[i];
	// if(map.containsKey(sum - k)){
	// len = Math.max(len, i - map.get(sum - k));
	// }
	// if(!map.containsKey(sum)){
	// map.put(sum, i);
	// }
	// }
	// System.out.println(len);
	// }

	public void maxLength(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(h[i], sum);
		}
		int len = 0;
		sum = 0;
		int pre = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(len, res);
		}
		System.out.println(res);
	}

	public int getLessIndex(int[] h, int index) {
		int left = 0;
		int right = h.length - 1;
		int mid = 0;
		int res = -1;
		while (left <= right) {
			mid = (left + right) / 2;
			if(h[mid] >= index){
				res = mid;
				right = mid - 1;
			}else if(h[mid] < index){
				left = mid + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
//		new Main1().maxLength(new int[] { 1, 2, 3, 3 }, 6);
		new Main1().maxLength(new int[]{0,3,1,-3,-3,3}, -2);
	}
}
