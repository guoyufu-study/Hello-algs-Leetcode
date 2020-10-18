package com.jasper.algs.contest.weekly.c083.qu0829.solu2;

/**
 * 0829. 连续整数求和
 * 
 * <p> 开方2N，定位界线。
 * <p> 整除奇数
 * <p> 取模偶数，余一半。 
 */
class Solution {
    public int consecutiveNumbersSum(int N) {
    	
    	int ans = 0;
    	int i = 1;
    	while(N > 0) {
    		if(N%i==0) ans++;
    		N-=i;
    		i++;
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	int N = 4;
		System.out.println(N | 1);
	}
}