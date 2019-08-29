package sdu.edu.leetcode.medium;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {

        int[] factorial = new int[n + 1];
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        int index;
        StringBuilder sb = new StringBuilder();
        factorial[0] = 1;
        for(int i = 1;i <= n;i++){
            sum *= i;
            factorial[i] = sum;
        }
        for(int i = 1;i <= n;i++){
            list.add(i);
        }
        k--;
        for(int i = 1;i <=n;i++){
            index = k / factorial[n - i];
            sb.append(list.remove(index));
            k -= index * factorial[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3, 3);
    }
}
