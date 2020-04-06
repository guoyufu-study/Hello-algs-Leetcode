package com.jasper.algs.leetcode.hashmap.qu0003.solu2;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>滑动窗口+字典查找</b>
 * <p>
 * 使用HashSet作为字典，左边界一步步滑动
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();//字典
        int ans = 0, i = 0, j = 0;// answer、窗口左边界、窗口右边界
        while (j < s.length()) {
        	// 重复
        	if (set.contains(s.charAt(j))){
	            set.remove(s.charAt(i++));//出字典，更新左边界
	            continue;
	       	 }
            // 不重复
            set.add(s.charAt(j++));//入字典，更新右边界
            ans = Math.max(ans, j - i);//更新最大长度
        }
        return ans;
    }
}
