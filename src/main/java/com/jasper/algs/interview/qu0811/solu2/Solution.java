package com.jasper.algs.interview.qu0811.solu2;


/**
 * 面试题 08.11. 硬币
 * 
 * <p> 数学
 */
class Solution {
	int mod = 1_000_000_007;
    public int waysToChange(int n) {
        int ans = 0;
        for (int i = 0; i * 25 <= n; ++i) {
            int rest = n - i * 25;
            int a = rest / 10;
            int b = rest % 10 / 5;
            ans = (ans + (int)((long)(a + 1) * (a + b + 1) % mod)) % mod;
        }
        return ans;
    }
}