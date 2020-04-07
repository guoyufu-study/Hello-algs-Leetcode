package com.jasper.algs.leetcode.twopointers.qu0003.solu3;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>优化后的滑动窗口+字典查找</b>
 * <p>
 * 使用HashMap作为字典，左边界一次滑动到位。
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> map = new HashMap<>();//字典
		int ans=0, i=0, j=0;// answer、窗口左边界、窗口右边界
		while(j<s.length()) {
			// 重复
			if(map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);//更新左边界
			}
			// 不论是否重复
			map.put(s.charAt(j), ++j);//入字典，更新右边界
			ans = Math.max(ans, j-i);//更新最大长度
		}
		return ans;
	}
}
