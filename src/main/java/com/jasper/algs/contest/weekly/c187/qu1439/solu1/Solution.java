package com.jasper.algs.contest.weekly.c187.qu1439.solu1;

/**
 * 1439. 有序矩阵中的第 k 个最小数组和
 * 
 * <p> 二分查找
 */
class Solution {
	private int[][] mat;
	private int count, k, m, n;
    public int kthSmallest(int[][] mat, int k) {
    	this.mat = mat; 
    	this.k = k;
    	m = mat.length; 
    	n = mat[0].length;
    	int lo = 0, hi = 0;
    	for (int i = 0; i < m; i++) {
			lo += mat[i][0];
			hi += mat[i][n-1];
		}
    	
    	if(k==1) return lo;
    	
    	int initsum = lo;
    	while(lo < hi) {
    		int mid = (lo+hi)/2;
    		count = 1;
    		dfs(0, initsum, mid);
    		if(count < k) {
    			lo = mid + 1;
    		} else 
    			hi = mid;
    	}
    	return lo;
    }
    
	private void dfs(int index, int initsum, int limit) {
		if (initsum > limit || index == m || count > k) {
            return;
        }
		
		dfs(index+1, initsum, limit);
		for (int j = 1; j < n; j++) {
			int sum0 = initsum + mat[index][j] - mat[index][0];
			if(sum0 > limit) break;
			count++;
			dfs(index+1, sum0, limit);
		}
	}
}