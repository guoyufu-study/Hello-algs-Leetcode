package com.jasper.algs.leetcode.maths.qu0202.solu2;

/**
 * 0202. 快乐数
 * 
 *	<p>弗洛伊德循环查找
 */
class Solution {
	public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        
        // 快乐数，或相遇，则终止
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
    
    public static void main(String[] args) {
		int n = 2;
		
		System.out.println(new Solution().isHappy(n));
	}
}