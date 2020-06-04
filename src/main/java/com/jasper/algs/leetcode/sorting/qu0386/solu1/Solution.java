package com.jasper.algs.leetcode.sorting.qu0386.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0386. 字典序排数
 *
 * <p> 10叉树前序遍历 ：递归
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
    	
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	for (int offset = 1; offset < 10; offset++) {
    		preOrder(n, offset, ans);
    	}
    	
    	return ans;
    }
    
    private void preOrder(int n, int prefix, List<Integer> ans) {
    	// 终止
    	if(prefix > n) 
    		return ;
    	
    	// 记录
    	ans.add(prefix);
    	
    	// 下一个
    	for (int offset = 0; offset < 10; offset++) {
    		preOrder(n, prefix*10+offset, ans);
		}
	}

	public static void main(String[] args) {
    	// [1,10,11,12,13,2,3,4,5,6,7,8,9]
    	int n = 13;
    	
    	System.out.println(new Solution().lexicalOrder(n));
    	
    	
	}
}