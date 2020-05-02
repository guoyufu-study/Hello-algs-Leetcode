package com.jasper.algs.leetcode.dynamicprogramming.qu0829.solu1;

/**
 * 0829. 连续整数求和
 * 
 * <p> 开方2N，定位界线。
 * <p> 整除奇数
 * <p> 取模偶数，余一半。 
 */
class Solution {
    public int consecutiveNumbersSum(int N) {
    	
    	int threshold = (int) Math.sqrt(2*N);
    	
    	int ans = 1;// N自身
    	for (int i = 2; i < threshold; i++) {
    		// 奇数
			if((i|1)==i) {
				if(N%i==0) ans++;
			} 
			// 偶数
			else 
				if(N%i==i>>1) ans++;
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	int N = 4;
		System.out.println(N | 1);
	}
}