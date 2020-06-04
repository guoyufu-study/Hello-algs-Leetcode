package com.jasper.algs.leetcode.permutation.qu0060.solu1;

import java.util.LinkedList;
import java.util.List;

/**
 * 0060.第k个排列
 * 
 *  <p> 康托展式
 */
class Solution {
    public String getPermutation(int n, int k) {

    	// 缓存阶乘
    	int[] factorials = new int[n];
    	factorials[0] = 1;
        for(int i = 1; i < n; ++i) {
          factorials[i] = factorials[i - 1] * i;
        }

    	// 缓存数字
    	List<Integer> nums = new LinkedList<Integer>();
    	for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

    	k--;
    	
    	// 康托展式
    	StringBuilder ans = new StringBuilder();
    	 for (int i = n - 1; i >= 0; --i) {
			int index = k/factorials[i];
			ans.append(nums.remove(index));
			k %= factorials[i];
		}
    	
    	return ans.toString();
    }
    
    public static void main(String[] args) {
    	// 213
    	int n = 3;
    	int k = 3;
		
    	// 2314
//    	int n = 4;
//    	int k = 9;
    	
		System.out.println(new Solution().getPermutation(n, k));
	}
}