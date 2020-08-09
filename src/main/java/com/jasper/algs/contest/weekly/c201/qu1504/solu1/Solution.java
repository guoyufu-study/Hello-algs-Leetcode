package com.jasper.algs.contest.weekly.c201.qu1504.solu1;

/**
 * 1504.找出第 N 个二进制字符串中的第 K 位
 * 
 * <p> 模拟
 */
class Solution {
    public char findKthBit(int n, int k) {
    	StringBuilder sb = new StringBuilder();
    	sb.append('0');
    	for (int i = 1; i < n; i++) {
			sb.append('1');
			for (int j = sb.length()-2; j >= 0; j--) {
				sb.append(sb.charAt(j)=='1' ? '0' : '1');
			}
			if(k<=sb.length()) break; // 优化
		}
    	
    	return sb.charAt(k-1);
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