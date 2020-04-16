package com.jasper.algs.leetcode.bitmanipulation.qu0448.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 原地修改，数字标识
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	// 原地修改，数字标识
    	for (int i = 0; i < nums.length; i++) {
			while(nums[nums[i]-1] != nums[i])
				swap(nums, nums[i]-1, i);
		}
    	
    	// 找出未标识的数字
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i+1)
				ans.add(i+1);
		}
    	
    	return ans;
    }

    /**
     * 交换元素
     */
	private void swap(int[] nums, int i, int i2) {
		assert i != i2:"同一槽位上的数字，不能使用异或交换";
		nums[i] = nums[i] ^ nums[i2];
		nums[i2] = nums[i] ^ nums[i2]; // 值为原nums[i]
		nums[i] = nums[i] ^ nums[i2]; // 值为原nums[i2]
	}
}