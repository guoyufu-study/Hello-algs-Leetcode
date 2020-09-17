package com.jasper.algs.leetcode.array.qu0800.solu1;

/**
 * 0800. 相似 RGB 颜色
 * 
 * <p> 暴力枚举
 */
class Solution {
	
	int[] sm = new int[] {0x0, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xAA, 0xBB, 0xCC, 0xDD, 0xEE, 0xFF};
	String[] sms = new String[] {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};
    
	public String similarRGB(String color) {
        int ai = getIndex(color.substring(1,3));
        int bi = getIndex(color.substring(3, 5));
        int ci = getIndex(color.substring(5, 7));
        
        return "#" + sms[ai] + sms[bi] + sms[ci];
    }
    
    int getIndex(String s) {
    	int a = Integer.parseInt(s, 16);
        int min = 1<<16, index = 0;
        for (int i = 0; i < 16; i++) {
			int multi = (a-sm[i])*(a-sm[i]);
			if(min > multi) {
				min = multi;
				index = i;
			}
		}
        
        return index;
    }
}