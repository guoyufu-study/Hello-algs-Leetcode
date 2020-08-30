package com.jasper.algs.contest.weekly.c095.qu0878.solu1;

/**
 * 0878. 第 N 个神奇数字
 * 
 * <p> 数学方法
 */
class Solution {
	
	private static final int MOD = 1_000_000_007;
	
    public int nthMagicalNumber(int N, int A, int B) {
    	int L = A / gcd(A, B) * B; // 最小公倍数
    	int M = L/A + L/B - 1; // [1,L]中可被A或B整除的数字个数
    	int q = N/M, r = N % M;
    	
    	 long ans = (long) q * L % MOD;
    	 
    	if(r==0) return (int) ans;
    	
    	int[] heads = new int[]{A, B};
        for (int i = 2; i <= r; ++i) {// 确保小值为第i个数
            if (heads[0] <= heads[1])
                heads[0] += A;
            else
                heads[1] += B;
        }
        ans += Math.min(heads[0], heads[1]);
        return (int) (ans % MOD);
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