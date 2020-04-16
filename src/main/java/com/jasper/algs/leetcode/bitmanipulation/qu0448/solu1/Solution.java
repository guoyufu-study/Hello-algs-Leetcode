package com.jasper.algs.leetcode.bitmanipulation.qu0448.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 原地修改，正负号标识
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	// 原地修改，正负号标识
    	for (int i = 0; i < nums.length; i++) {
    		if(nums[i]<0 && nums[-nums[i]-1] > 0) {
    			nums[-nums[i]-1] =  -nums[-nums[i]-1];
    		} else if(nums[i]>0 && nums[nums[i]-1] > 0) {
    			nums[nums[i]-1] =  -nums[nums[i]-1];
    		}
		}
    	
    	// 找出未标识数字
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0)
				ans.add(i+1);
		}
    	return ans;
    }
    
    
    public static void main(String[] args) {
	}
}