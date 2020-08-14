package com.jasper.algs.interview.qu1606.solu2;

import java.util.Arrays;

/**
 * 面试题 16.06. 最小差
 * 
 * <p> 排序 + 双指针
 */
class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int m = a.length, n = b.length,
        		i = 0, j = 0;
        long ans = Integer.MAX_VALUE;
        while(i<m && j<n) {
        	if(a[i]==b[j]) return 0;
        	if(a[i]<b[j]) {
        		ans = Math.min(ans, b[j] + 0L -a[i]);
        		i++;
        	} else {
        		ans = Math.min(ans, a[i] + 0L - b[j]);
        		j++;
        	}
        }
        
        return (int)ans;
    }
    
}