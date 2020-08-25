package com.jasper.algs.contest.weekly.c156.qu1208.solu1;

/**
 * 1208. 尽可能使字符串相等
 * 
 * <p> 滑动窗口
 */
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
    	int n = s.length();
    	char[] sc = s.toCharArray();
    	char[] tc = t.toCharArray();
    	
    	// 求距离
    	int[] dists = new int[n];
    	for (int i = 0; i < n; i++) {
			dists[i] = Math.abs(sc[i] - tc[i]);
		}
    	
    	// 求最大长度：滑动窗口
    	int ans = 0, left = 0, right = 0, sum = 0;
    	while(right<n) {
    		sum += dists[right];
    		if(sum<=maxCost)
    			ans = Math.max(ans, right-left+1);
    		else {
    			sum -= dists[left];
    			left++;
    		}
			right++;
    	}
    	
    	return ans;
    }
}