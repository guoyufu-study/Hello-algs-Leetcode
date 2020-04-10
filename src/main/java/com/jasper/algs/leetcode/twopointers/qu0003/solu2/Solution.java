package com.jasper.algs.leetcode.twopointers.qu0003.solu2;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>滑动窗口+字典查找</b>
 * <p>
 * 使用HashSet作为字典，左边界一步步滑动
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
        int ans = 0, // 答案
    		left = 0, //窗口左边界（含）
    		right = 0;//窗口右边界（不含）
        
        // 字典:记录滑动窗口内的字符
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
        	// 重复
        	while(set.contains(s.charAt(right))){
	            set.remove(s.charAt(left++));//出字典，更新左边界
	       	 }
            // 不重复
            set.add(s.charAt(right));//入字典
            right++;//更新右边界
            ans = Math.max(ans, right - left);//更新最大长度
        }
        
        return ans;
    }
}
