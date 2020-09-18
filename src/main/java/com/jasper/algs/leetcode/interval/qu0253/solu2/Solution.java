package com.jasper.algs.leetcode.interval.qu0253.solu2;

import java.util.Arrays;

/**
 * 0253. 会议室 II
 * 
 * <p> 有序化
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length, index = 0;
        int[] ST = new int[n];
        int[] ET = new int[n];
        for(int[] interval : intervals) {
            ST[index] = interval[0];
            ET[index++] = interval[1];
        }
        Arrays.sort(ST);
        Arrays.sort(ET);

        int a = 0, b = 0;
        while(a < n) {
            if(ST[a] >= ET[b])  // 腾出会议室
                b++;
            a++; // 占用会议室
        }

        return a - b;
    }
}