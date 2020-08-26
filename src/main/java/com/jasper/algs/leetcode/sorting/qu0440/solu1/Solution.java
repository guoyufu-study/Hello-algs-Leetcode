package com.jasper.algs.leetcode.sorting.qu0440.solu1;

/**
 * 0440. 字典序的第K小数字
 *
 * <p> 暴力计数：十叉树前序遍历
 */
class Solution {
    private int k;
    public int findKthNumber(int n, int k) {
        this.k = k;
        
        // 十叉树前序遍历
        return find(n, 0);
    }

    int find(int n, int prefix) {
        if(k==0) 
        	return prefix;
        
        for(int i=0; i<=9; i++) {
            int pc = prefix * 10 + i;
            if(pc==0) continue;
            if(pc<=n) {
                --k;
                int ans = find(n, pc);
                if(k==0) return ans;
            }
        }

        return -1;
    }
}