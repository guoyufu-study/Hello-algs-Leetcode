package com.jasper.algs.leetcode.twopointers.qu0925.solu1;

/**
 * 0925. 长按键入
 * 
 * <p> 双指针
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
       
    	int i = 0, j = 0;
    	while(i<name.length() && j<typed.length()) {
    		// 字符不同
    		if(name.charAt(i)!=typed.charAt(j))
    			return false;
    		
    		// 字符不足
    		int count_name = count(name, i);
    		int count_typed = count(typed, j);
    		if(count_name > count_typed)
    			return false;

    		// 步进
    		i += count_name;
    		j += count_typed;
    	}
    	
    	return i<name.length() || j<typed.length() ? false // 有多余字符
    			: true;
    }
    
    private int count(String s, int i) {
    	int count = 0;
    	char c = s.charAt(i);
		while(i<s.length() && s.charAt(i)==c) {
			count++;
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
    	// true
		String name = "alex";
		String typed = "aaleex";
		
		// false 字符不足
//		String name = "saeed";
//		String typed = "ssaaedd";
		
		// true
//		String name = "leelee";
//		String typed = "lleeelee";
		
		// true
//		String name = "laiden";
//		String typed = "laiden";
		
		// false 字符不同
//		String name = "laidez";
//		String typed = "laideccc";
		
		System.out.println(new Solution().isLongPressedName(name, typed));
	}
}