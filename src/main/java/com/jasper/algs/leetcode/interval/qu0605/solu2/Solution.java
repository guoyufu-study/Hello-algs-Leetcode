package com.jasper.algs.leetcode.interval.qu0605.solu2;

/**
 * 0605. 种花问题
 *
 * <p>数学计算：不用改变原数组
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

    	int N = flowerbed.length;
    	
    	// 边界
    	if((N+1)/2 < n) return false;
    	if(n==0) return true;//[1,0,1,0,1,0,1] 0
    	
    	// 种花
    	int ans = 0;
    	int count = 1; // 计数0，注意处理开头
    	for (int i = 0; i < N; i++) {
    		// 遇0，计数
    		if(flowerbed[i]==0) {
    			count++;
    			continue;
    		}
    		
    		// 遇1，结算能种花的数量
    		ans += (count-1)/2;
    		if(ans>=n) return true;
    		
    		// 重置计数
    		count = 0;
    		
		}
    	
    	// 处理结尾
    	count++;
    	ans += (count-1)/2;
    	
    	return ans>=n;
    }
}