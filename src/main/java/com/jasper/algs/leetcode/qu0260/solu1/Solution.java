package com.jasper.algs.leetcode.qu0260.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap计数
 */
public class Solution {

	public int[] singleNumber(int[] nums) {
		Map<Integer, Integer> hashmap = new HashMap<>();
		for (int n : nums)	//入字典
			hashmap.put(n, hashmap.getOrDefault(n, 0) + 1);

		int[] ans = new int[2];
		int idx = 0;
		for (Map.Entry<Integer, Integer> item : hashmap.entrySet())//查字典
			if (item.getValue() == 1)
				ans[idx++] = item.getKey();

		return ans;
	}

}
