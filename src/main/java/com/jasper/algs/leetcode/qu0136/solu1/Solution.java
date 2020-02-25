package com.jasper.algs.leetcode.qu0136.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet求和
 */
public class Solution {

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		long sumarray=0;
		for (int num : nums) {
			set.add(num);
			sumarray+=num;
		}
		
		long sumset=0;
		for (int num : set) sumset+=num;
		
		return (int)(2*sumset-sumarray);
    }
}
