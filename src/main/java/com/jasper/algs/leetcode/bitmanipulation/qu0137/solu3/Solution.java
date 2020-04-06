package com.jasper.algs.leetcode.bitmanipulation.qu0137.solu3;

public class Solution {

	public int singleNumber(int[] nums) {
		int seenOnce=0, seenTwice=0;
		for (int num : nums) {
			// 第一次出现，将num添加到seenOnce，seenTwice不变
			// 第二次出现，将num移除出seenOnce，将num添加到seenTwice；
			// 第三次出现，seenOnce不变，将num移除出seenTwice；
			seenOnce = ~seenTwice & (seenOnce ^ num);
			seenTwice = ~seenOnce & (seenTwice ^ num);
		}
		return seenOnce;
    }
}
