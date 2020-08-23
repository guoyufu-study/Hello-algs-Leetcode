package com.jasper.algs.leetcode.bitmanipulation.qu0136.solu3;

import java.util.HashSet;
import java.util.Set;

/**
 * 0136.只出现过一次的数字
 * 
 * <p> HashSet求和
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
