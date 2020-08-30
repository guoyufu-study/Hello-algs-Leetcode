package com.jasper.algs.contest.weekly.c095.qu0878.solu2;

/**
 * 0878. 第 N 个神奇数字
 * 
 * <p> 二分查找
 */
class Solution {
	
	private static final int MOD = 1_000_000_007;
	
    public int nthMagicalNumber(int N, int A, int B) {
    	int L = A / gcd(A, B) * B; // 最小公倍数
    	
    	long lo = 0, hi = (long) 1e15;
    	while(lo < hi) {
    		long mid = (lo+hi)/2;
    		if(mid/A + mid/B - mid/L < N) {
    			lo = mid + 1;
    		} else {
    			hi = mid;
    		}
    	}
        return (int)(lo % MOD);
    }
    
    private int gcd(int a, int b) {
		return b==0 ? a : gcd(b, a%b);
	}

	public static void main(String[] args) {
    	// 2
//		int N = 1;
//		int A = 2;
//		int B = 3;
		
		// 6
//		int N = 4;
//		int A = 2;
//		int B = 3;
		
		// 10
//		int N = 5;
//		int A = 2;
//		int B = 4;
		
		// 8
		int N = 3;
		int A = 6;
		int B = 4;
		
		System.out.println(new Solution().nthMagicalNumber(N, A, B));
	}
}