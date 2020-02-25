package com.jasper.algs.leetcode.qu0137.solu2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int key : nums) 
			map.put(key, map.getOrDefault(key, 0)+1);//HashMap计数
			
		for (int ans : map.keySet()) 
			if(map.get(ans)==1)  return ans;//找出计数为1的key
		
		return -1;
    }
}
