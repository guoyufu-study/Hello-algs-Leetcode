package com.jasper.algs.leetcode.string.qu0345.solu1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 0345. 反转字符串中的元音字母
 *
 * <p> 辅助字典 + 双指针
 */
class Solution {
	public String reverseVowels(String s) {
        int left = 0, n = s.length(), right = n-1;
        char[] sc = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        Collections.addAll(set, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while(left<right) {
            while(left<right && !set.contains(sc[left])) left++;
            while(left<right && !set.contains(sc[right])) right--;
            if(left<right) {
                char c = sc[left];
                sc[left] = sc[right];
                sc[right] = c;
                left++;
                right--;
            }
        }

        return new String(sc);
    }
}
