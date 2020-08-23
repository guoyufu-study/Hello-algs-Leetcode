package com.jasper.algs.leetcode.bitmanipulation.qu0137.solu6;

/**
 * 0137. 只出现过一次的数字2
 * 
 * <p>位掩码
 */
public class Solution {

	public int singleNumber(int[] nums) {
		int seenOnce=0, seenTwice=0;
		for (int num : nums) {
			// 第一次出现，将num添加到seenOnce，seenTwice不变
			// 第二次出现，将num移除出seenOnce，将num添加到seenTwice；
			// 第三次出现，seenOnce不变，将num移除出seenTwice；
			seenOnce = (seenOnce ^ num) & ~seenTwice;
			seenTwice = ~seenOnce & (seenTwice ^ num);
			
		}
		return seenOnce;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,2,3,2};
		System.out.println(new Solution().singleNumber(nums));
	}
}
