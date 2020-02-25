package com.jasper.algs.leetcode.qu0137.solu4;

public class Solution {

	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; ++i) {//遍历每个位
			int sum = 0;
			for (int j = 0; j < nums.length; ++j) {//统计nums在某个位i上出现1的次数
				sum += (nums[j] >> i) & 1;
			}
			res ^= (sum % 3) << i;//对sum进行%3处理，得到的结果就是目的数字在该位上的值
		}
		return res;
	}

}
