package com.jasper.algs.contest.weekly.c156.qu1207.solu1;

/**
 * 1207. 独一无二的出现次数
 * 
 * <p> 辅助字典：计数 + 判重
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
    	// 计数
    	int[] counts = new int[2_001];
    	for(int num : arr) {
    		counts[num+1_000]++;
    	}
    	
    	// 判重
    	int[] helper = new int[1_001];
    	for (int count : counts) {
    		if(count!=0 && helper[count]!=0)
    			return false;
    		
    		helper[count]++;
		}
    	return true;
    }
}