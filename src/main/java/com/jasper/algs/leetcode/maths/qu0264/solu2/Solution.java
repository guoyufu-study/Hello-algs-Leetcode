package com.jasper.algs.leetcode.maths.qu0264.solu2;

/**
 * 0264. 丑数 II
 *
 * <p>
 * 动态规划
 */
class Solution {

	public static Ugly u = new Ugly();

	public int nthUglyNumber(int n) {
		return u.nums[n - 1];
	}

	public static void main(String[] args) {
		int n = 1690;
		System.out.println(new Solution().nthUglyNumber(n));
	}
}

class Ugly {
	
	public int[] nums = new int[1690];

	Ugly() {
		nums[0] = 1;
		int ugly, i2 = 0, i3 = 0, i5 = 0;

		for (int i = 1; i < 1690; ++i) {
			ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
			nums[i] = ugly;
			
			// 注意值有可能重复
			if (ugly == nums[i2] * 2)
				++i2;
			if (ugly == nums[i3] * 3)
				++i3;
			if (ugly == nums[i5] * 5)
				++i5;
		}
	}
}
