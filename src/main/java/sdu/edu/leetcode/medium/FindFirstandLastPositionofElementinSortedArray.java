package sdu.edu.leetcode.medium;

public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearchBegin(nums, target), binarySearchEnd(nums, target)};
    }

    public int binarySearchBegin(int[] num,int target){
        int left = 0;
        int right = num.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(num[mid] > target){
                right = mid - 1;
            }else if(num[mid] < target){
                left = mid + 1;
            }else{
                if(mid != 0 && num[mid - 1] == target){
                    right = mid - 1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }

    public int binarySearchEnd(int[] num,int target){
        int left = 0;
        int right = num.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(num[mid] > target){
                right = mid - 1;
            }else if(num[mid] < target){
                left = mid + 1;
            }else{
                if(mid != num.length - 1 && num[mid + 1] == target){
                    left = mid + 1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }

}
