package com.jasper.algs.leetcode.greedy.qu1386.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 1386. 安排电影院座位
 * 
 */
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    	
    	// 掩码
    	int left = 0b11110000;// 左侧可用
        int middle = 0b11000011; //中间可用
        int right = 0b00001111; // 右侧可用

        // 占座
        Map <Integer, Integer> occupied = new HashMap <Integer, Integer> ();
        for (int[] seat: reservedSeats) {
            if (seat[1] >= 2 && seat[1] <= 9) {
                int origin = occupied.containsKey(seat[0]) ? occupied.get(seat[0]) : 0;
                int value = origin | (1 << (seat[1] - 2));
                occupied.put(seat[0], value);
            }
        }

        int ans = (n - occupied.size()) * 2;
        for (int bitmask : occupied.values()) {
            if (((bitmask | left) == left) // 最右侧4个位置被占
            		|| ((bitmask | middle) == middle)// 两侧位置被占
            		|| ((bitmask | right) == right)) {// 最左侧位置被占
                ++ans;
            }
        }
        return ans;

    }
}