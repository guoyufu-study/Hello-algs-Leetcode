package com.jasper.algs.contest.weekly.c094.qu0873.solu2;

import java.util.HashSet;
import java.util.Set;

/**
 * 0873. 最长的斐波那契子序列的长度
 * 
 * <p> 辅助字典
 */
class Solution {
    public int lenLongestFibSubseq(int[] A) {

    	int n = A.length, ans = 0;
    	Set<Integer> helper = new HashSet<Integer>();
    	for(int a : A) helper.add(a);
    	
    	for(int i=0; i<n-2; i++) {
    		for(int j=i+1; j<n-1; j++) {
    			int a = A[i], b = A[j], z = a+b, count = 2;
    			while(helper.contains(z)) {
    				count++;
    				a = b;
    				b = z;
    				z = a+b;
    			}
    			ans = Math.max(ans, count);
    		}
    	}
    	return ans < 3 ? 0 : ans;
    }
}