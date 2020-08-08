package com.jasper.algs.leetcode.twopointers.qu0925.solu;

/**
 * 0925. 长按键入
 * 
 * <p> 2刷
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
    	return false;
    }
    
    public static void main(String[] args) {
    	// true
//		String name = "alex";
//		String typed = "aaleex";
		
		// false
//		String name = "saeed";
//		String typed = "ssaaedd";
		
		// true
//		String name = "leelee";
//		String typed = "lleeelee";
		
		// true
		String name = "laiden";
		String typed = "laiden";
		
		System.out.println(new Solution().isLongPressedName(name, typed));
	}
}