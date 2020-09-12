package com.jasper.algs.leetcode.twopointers.qu0027.solu1;

/**
 * 0027.移除元素
 * 
 * <p> 快慢指针：拷贝覆盖
 */
public class Solution {

	public int removeElement(int[] nums, int val) {
		// 快慢指针
        int slow = 0, fast = 0, n = nums.length;
        while(fast < n) {
            if(nums[fast]!=val) nums[slow++] = nums[fast];
            fast++;
        }
        return slow;
    }
}
