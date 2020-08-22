package com.jasper.algs.contest.biweekly.bc33.qu5481.solu1;

/**
 * 5481. 得到目标数组的最少函数调用次数
 * 
 * <p> 数学
 */
class Solution {
    public int minOperations(int[] nums) {
    	int ans = 0, max = 0, count = 0;
    	for(int num : nums) {
    		while(num!=0) {
    			while(num%2==0) {
    				count++;
    				num >>= 1;
    			}
    			if(num%2==1) {
    				ans++;
    				num -= 1;
    			}
    		}
    		max = Math.max(max, count);
    		count = 0;
    	}
    	
    	ans += count;
    	return ans;
    }
}