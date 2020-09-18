package com.jasper.algs.leetcode.hashmap.qu0246.solu1;

/**
 * 0246. 中心对称数
 * 
 * <p> 字典映射 + 左右指针
 */
class Solution {
    public boolean isStrobogrammatic(String num) {
    	// 字典映射
        char[] map = new char[] {'0', '1', 'a', 'a', 'a', 'a','9', 'a', '8', '6'};
        // 左右指针
        int left = 0, right = num.length()-1;
        while(left <= right) { // 注意中间字符必须判断
            if(map[num.charAt(left)-'0']!=num.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}