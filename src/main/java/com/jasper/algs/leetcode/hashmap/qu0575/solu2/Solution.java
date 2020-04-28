package com.jasper.algs.leetcode.hashmap.qu0575.solu2;

/**
 * 0575. 分糖果
 *
 * <p>使用字典统计糖果种类（优化）
 */
class Solution {
    public int distributeCandies(int[] candies) {
    	
    	int half = candies.length>>1;
    	
    	// 统计糖果种类
    	boolean[] helper = new boolean[100000-(-100000)+1];// 辅助数组，true表示种类存在
    	int k = 0;
    	for (int n : candies) {
    		n += 100000;
			if(!helper[n]) { //种类不存在时，统计并标记已存在
				k++;
				if(k >= half) return half;//种类过糖果半数时，不必再统计
				helper[n] = true;
			}
		}
    	
    	return  k;
    }
}