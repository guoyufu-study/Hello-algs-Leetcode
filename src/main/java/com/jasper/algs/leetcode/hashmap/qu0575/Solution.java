package com.jasper.algs.leetcode.hashmap.qu0575;

import java.util.stream.IntStream;

/**
 * 0575. 分糖果
 *
 * <p>使用字典统计糖果种类
 */
class Solution {
    public int distributeCandies(int[] candies) {
    	
    	return  Math.min((int)IntStream.of(candies).distinct().count() // 统计糖果种类
    			, candies.length/2);
    }
}