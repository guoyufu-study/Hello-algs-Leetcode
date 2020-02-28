package com.jasper.algs.leetcode.qu0027.solu1;

/**
 * 拷贝覆盖
 */
public class Solution {

	public int removeElement(int[] nums, int val) {
		int ans=0;
		for (int num : nums) {
			if(num!=val) {
				nums[ans]=num;
				ans++;
			}
		}
		return ans;
    }
}
