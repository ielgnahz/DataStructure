package sdu.edu.leetcode.medium;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(divisor == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }
        int sign = ((dividend >> 31) + (divisor >> 31)) % 2 == 0?1:-1;
        dividend = dividend < 0?dividend:-dividend;
        divisor = divisor < 0?divisor : -divisor;
        return sign * helper(dividend,divisor);
    }

    public int helper(int dividend, int divisor){
        if(dividend > divisor) return 0;
        int count = 0;
        while((divisor<< count) < 0 && (dividend - (divisor<< count)) <= 0){
            count++;
        }
        return (1 << (count - 1)) + helper(dividend - (divisor<<(count - 1)), divisor);
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(7, -3));
    }

}
