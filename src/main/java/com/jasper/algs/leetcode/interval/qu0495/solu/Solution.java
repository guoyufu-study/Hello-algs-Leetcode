package com.jasper.algs.leetcode.interval.qu0495.solu;

/**
 * 0495. 提莫攻击
 * 
 * <p> 5 刷
 */
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    	
    	// 边界
    	if(timeSeries==null || timeSeries.length==0)
    		return 0;
    	if(duration==0) return 0;
    	
    	int N = timeSeries.length;
    	
    	// 累计时间
    	int ans = 0;
    	for (int i = 1; i < N; i++) {
			ans += Math.min(duration, timeSeries[i]- timeSeries[i-1]);
		}
    	
    	// 注意最后一击
    	return ans+duration;
    }
}