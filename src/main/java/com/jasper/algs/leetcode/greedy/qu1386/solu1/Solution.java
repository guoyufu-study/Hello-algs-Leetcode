package com.jasper.algs.leetcode.greedy.qu1386.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1386. 安排电影院座位
 * 
 */
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    	
    	Map<Integer, Integer> helper = new HashMap<Integer, Integer>();
    	
    	// 标记不可能构造成功的四人连座
    	for (int i = 0; i < reservedSeats.length; i++) {
    		int index = reservedSeats[i][0]; // 行号
			switch (reservedSeats[i][1]) { // 座号
			case 2:
			case 3:
				helper.compute(index, (key, oldValue) -> {
					return oldValue==null? 0b100 : (oldValue | 0b100);
				});
				break;
			case 4:
			case 5:
				helper.compute(index, (key, oldValue) -> {
					return oldValue==null? 0b110 : (oldValue | 0b110);
				});
				break;
			case 6:
			case 7:
				helper.compute(index, (key, oldValue) -> {
					return oldValue==null? 0b011 : (oldValue | 0b011);
				});
				break;
			case 8:
			case 9:
				helper.compute(index, (key, oldValue) -> {
					return oldValue==null? 0b001 : (oldValue | 0b001);
				});
				break;
			default:
				break;
			}
		}
    	
    	// 可能安排的最大数量
    	int ans = 2*n;// 0b000 不存在，默认值
    	for (int key : helper.keySet()) {
    		// 0b110 => 6
    		// 0b101 => 5
    		// 0b100 => 4
    		// 0b011 => 3
    		// 0b001 => 1
    		if(helper.get(key)<7) ans--;
    		// 0b111
    		else ans-=2;
		}
    	return ans;
    }
}