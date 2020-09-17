package com.jasper.algs.leetcode.array.qu0800.solu2;

/**
 * 0800. 相似 RGB 颜色
 * 
 * <p> 独立性 + 数学
 */
class Solution {
	
	public String similarRGB(String color) {
        return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
    }

    public String f(String comp) {
        int q = Integer.parseInt(comp, 16);
        q = q / 17 + (q % 17 > 8 ? 1 : 0);
        return String.format("%02x", 17 * q);
    }
}