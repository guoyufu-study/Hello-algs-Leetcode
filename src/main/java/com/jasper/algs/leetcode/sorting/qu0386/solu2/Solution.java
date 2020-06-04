package com.jasper.algs.leetcode.sorting.qu0386.solu2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 0386. 字典序排数
 *
 * <p> 10叉树前序遍历 ：迭代
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
    	
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	Stack<Integer> prefixs = new Stack<>();
    	for (int offset = 9; offset >= 1; offset--) {
    		if(offset <= n)
    			prefixs.push(offset);
		}
    	
    	while(!prefixs.isEmpty()) {
    		int prefix = prefixs.pop();
    		
    		// 记录
    		ans.add(prefix);
    		
    		// 入栈
    		for (int offset = 9; offset >= 0; offset--) {
    			int curn = prefix*10 + offset;
    			if(curn<=n)
    				prefixs.push(curn);
			}
    	}
    	
    	return ans;
    }
    
	public static void main(String[] args) {
    	// [1,10,11,12,13,2,3,4,5,6,7,8,9]
    	int n = 13;
    	
    	System.out.println(new Solution().lexicalOrder(n));
    	
    	
	}
}