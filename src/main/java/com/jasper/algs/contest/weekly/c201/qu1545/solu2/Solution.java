package com.jasper.algs.contest.weekly.c201.qu1545.solu2;

/**
 * 1504.找出第 N 个二进制字符串中的第 K 位
 * 
 * <p> 数学运算
 */
class Solution {
    public char findKthBit(int n, int k) {
    	int count = 0;
    	for (int i = 0; i < n; i++) {
    		count = (count<<1) + 1;
    		if(k==count+1) return '1';
			if(k<=count) break;
		}
    	
    	boolean isSame = true;
    	while(k>1) {
    		k = count - k + 1;
    		isSame = !isSame;
    		while(k<count) count >>= 1;
    		if(k==count+1) return isSame ? '1' : '0';
    		if(k>count) count = (count<<1) + 1;
    	}
    	
    	return isSame ? '0' : '1';
    }
    
    public static void main(String[] args) {
    	// 0
    	int n = 3, k = 1;
    	
    	// 1
//    	int n = 4, k = 11;
    	
    	// 0
//    	int n = 1, k = 1;
    	
    	// 1
//    	int n = 2, k = 3;
    	
    	// 中间值
    	// 1
//    	int n = 3, k = 2;
    	
    	// 0
//    	int n = 4, k = 12;
    	
    	// 1
//    	int n = 6, k = 58;

    	System.out.println(new Solution().findKthBit(n, k));
	}
}