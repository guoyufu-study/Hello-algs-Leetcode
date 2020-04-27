package com.jasper.algs.leetcode.maths.qu0202.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 0202. 快乐数
 * 
 *	<p>暴力循环
 */
class Solution {
    public boolean isHappy(int n) {
    	// 边界，必须是正整数
        if(n<1) return false;
        if(n==1) return true;
        
        // 辅助字典，判断是否循环
        Set<Integer> helper = new HashSet<Integer>();
        
        while(n!=1) {
        	helper.add(n);
        	int sum = 0;
        	while(n!=0) {
        		int digit = n%10;
        		sum += digit * digit;
        		n /= 10;
        	}
        	// 循环，不是快乐数，终止
        	if(helper.contains(sum)) 
        		return false;
        	n = sum;
        }
        
        // n==1，是快乐数
        return true;
    }
    
    public static void main(String[] args) {
		int n = 2;
		
		System.out.println(new Solution().isHappy(n));
	}
}