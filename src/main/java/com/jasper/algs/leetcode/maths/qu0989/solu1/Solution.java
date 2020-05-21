package com.jasper.algs.leetcode.maths.qu0989.solu1;

import java.util.LinkedList;
import java.util.List;

/**
 * 0989. 数组形式的整数加法
 *
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
    	
    	List<Integer> ans = new LinkedList<Integer>();
    	for (int i = A.length-1; i >= 0 ; i--) {
    		int sum = A[i] + K;
			ans.add(0, sum%10);
			K = sum / 10;
		}
    	
    	while(K>0) {
    		ans.add(0, K%10);
    		K /= 10;
    	}
    	
    	return ans;
    }
}