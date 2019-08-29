package sdu.edu.Test;

import java.util.*;

public class Test {

    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i <nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int c = 0;
        int sum = 0;
        int cur = 0;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + c;
            cur = sum % 10;
            c = sum / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            sum = l1.val + c;
            cur = sum % 10;
            c = sum / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1.next;
        }

        while(l2 != null){
            sum = l2.val + c;
            cur = sum % 10;
            c = sum / 10;
            head.next = new ListNode(cur);
            head = head.next;
            l2 = l2.next;
        }
        if(c != 0){
            head.next = new ListNode(c);
        }
        return dummy.next;
    }

    public int lengthOfLonestSubstring(String s){
        char[] chrs = s.toCharArray();
        int max = 0;
        int pre = 0;
        for(int i = 0;i < chrs.length;i++){
            for(int j = pre;j < i;j++){
                if(chrs[i] == chrs[j]){
                    max = Math.max(i - pre, max);
                    pre = j + 1;
                    break;
                }
            }
        }
        return Math.max(max, chrs.length - pre);
    }

    public String longestPalindrome(String s){
        int start = 0;
        int end = 0;
        int len = 0;
        char[] chrs = s.toCharArray();
        for(int i = 0;i < s.length();i++){
            int len1 = expancenter(i,i,chrs);
            int len2 = expancenter(i,i+1,chrs);
            len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len + 1) / 2 + 1;
                end = i + len / 2 + 1;
            }
        }
        return s.substring(start, end);
    }

    public int expancenter(int L,int R,char[] chrs){
        while(L >= 0 && R < chrs.length && chrs[L] == chrs[R]){
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String convert(String s,int numRows){
        StringBuilder sb = new StringBuilder();
        int cycLen = 2 * numRows - 2;
        for(int i = 0;i < numRows;i++){
            for(int j = 0;j + i < s.length();j += cycLen){
                sb.append(s.charAt(j + i));
                if(i != 0 && i != numRows - 1 && j + cycLen - i < s.length()){
                    sb.append(s.charAt(j + cycLen - i));
                }
            }
        }
        return sb.toString();
    }

    public int reverse(int x){
        int res = 0;
        while(x != 0){
            int p = x % 10;
            x = x / 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && x > 7)){
                return 0;
            }
            if(res < Integer.MAX_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && x < -8)){
                return 0;
            }
            res = res * 10 + p;
        }
        return res;
    }

    public boolean isMatch(String s, String p){
        return isMatch(s.toCharArray(),0,p.toCharArray(),0);
    }

    public boolean isMatch(char[] s,int si,char[] p,int pi){
        if(si == s.length){
            return pi == p.length;
        }
        boolean flag = false;
        if(si < s.length && (s[si] == p[pi] || p[pi] == '.')){
            flag = true;
        }
        if(pi + 1 < p.length && p[pi + 1] == '*'){
            return isMatch(s, si, p, pi+2) || (flag && isMatch(s, si+1, p, pi));
        }else{
            return flag && isMatch(s, si+1, p, pi+1);
        }
    }

    public int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left != right){
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == -nums[i]){
                    result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right &&  nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(nums[left] + nums[right] < -nums[i]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits){
        if(digits.length() == 0){
            return Collections.emptyList();
        }
        String[] strs = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        trace(0, strs, digits, new StringBuilder(), result);
        return result;
    }

    public void trace(int index, String[] strs, String digit, StringBuilder sb, List<String> result){
        if(index == digit.length()){
            result.add(sb.toString());
            return;
        }
        String str = strs[digit.charAt(index) - '0'];
        for(int i = 0;i < str.length();i++){
            sb.append(str.charAt(i));
            trace(index + 1, strs, digit, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }

    public List<String> generateParentheses(int n){
        List<String> result = new ArrayList<>();
        commons("",n,n, result);
        return result;
    }

    public void commons(String str, int open,int close,List<String> result){
        if(close < open){
            return;
        }
        if(open == 0 && close == 0){
            result.add(str);
            return;
        }
        if(open > 0){
            commons(str + "(", open - 1, close, result);
        }
        if(close > 0){
            commons(str + ")", open, close - 1, result);
        }
    }

    public ListNode swapPairs(ListNode head){
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null && next != null){
            cur.next = next.next;
            pre.next = next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
            next = cur != null?cur.next:null;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k){
        if(k <= 1) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while(pre != null){
            pre = reverse(pre, k);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode left, int k){
        ListNode right = left;
        while(right != null && k != 0){
            k--;
            right = right.next;
        }
        if(right == null){
            return null;
        }else{
            right = right.next;
            ListNode pre = left.next;
            ListNode cur = pre.next;
            ListNode next = null;
            ListNode head = pre;
            pre.next = right;
            while(cur != right){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            left.next = pre;
            return head;
        }
    }

    public int removeDuplicate(int[] nums){
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }

    public int removeElement(int[] nums, int val){
        int i = 0;
        int tail = 0;
        while(i < nums.length){
            if(nums[i] != val){
                nums[tail++] = nums[i];
            }
            i++;
        }
        return tail;
    }

    public int strStr(String haystack, String needle){
        for(int i = 0;;i++){
            for(int j = 0;;j++){
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                if(needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public void nextPermutation(int[] nums){
        if(nums.length == 0 || nums.length == 1)return;
        for(int i = nums.length - 1;i > 0;i--){
            if(nums[i - 1] < nums[i]){
                for(int j = nums.length - 1;j >= i;j--){
                    if(nums[j] > nums[i - 1]){
                        swap(nums, i - 1 , j);
                        reverse(nums, i, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    public int longestValidParenttheses(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        char[] chrs = s.toCharArray();
        for(int i = 0;i < chrs.length;i++){
            if(chrs[i] == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push(i);
                    }else{
                        ans = Math.max(ans, i - stack.peek());
                    }
                }
            }
        }
        return ans;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public void reverse(int[] nums,int i,int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }

    public void swap(int[] nums, int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if(target == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        trace(candidates, 0,target,new ArrayList<Integer>(),result);
        return result;
    }

    public void trace(int[] candidates,int i,int sum,List<Integer> list, List<List<Integer>> result){
        if(sum == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int k = i;k < candidates.length;k++){
            if(sum - candidates[k] >= 0 ){
                list.add(candidates[k]);
                trace(candidates, k, sum - candidates[k], list,result);
                list.remove(list.size() - 1);
            }else{
                break;
            }
        }
    }

    public int firstMissingPositive(int[] nums){
        if(nums.length == 0) return 1;
        for(int i = 0;i < nums.length;i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != i+1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public boolean isMatch2(String s, String p){
        int sIndex = 0,pIndex = 0,startIndex = -1,match = 0;
        while(sIndex < s.length()){
            if(pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
                sIndex++;pIndex++;
            }else if(pIndex < p.length() && p.charAt(pIndex) == '*'){
                startIndex = pIndex;
                match = sIndex;
                pIndex++;
            }else if(startIndex != -1){
                sIndex = ++match;
                pIndex = startIndex + 1;
            }else{
                return false;
            }
        }
        while(pIndex < p.length() && p.charAt(pIndex) == '*'){
            pIndex++;
        }
        return pIndex == p.length();
    }




    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        list.stream().forEach(item -> new Edge(1, 2, 3));
    }

    static class Edge{
        int begin;
        int end;
        int weight;
        public Edge(int begin,int end,int weight){
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;
    }
}




}