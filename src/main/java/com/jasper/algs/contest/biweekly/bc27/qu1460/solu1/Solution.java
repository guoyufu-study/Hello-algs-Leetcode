package com.jasper.algs.contest.biweekly.bc27.qu1460.solu1;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * 
 * <p> 字典计数
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
    	
    	int[] helper = new int[1001];
    	for (int i = 0; i < arr.length; i++) {
			helper[target[i]]++;
			helper[arr[i]]--;
		}
    	
    	for (int i = 0; i < helper.length; i++) {
			if(helper[i]!=0) 
				return false;
		}
    	
    	return true;
    }
}
