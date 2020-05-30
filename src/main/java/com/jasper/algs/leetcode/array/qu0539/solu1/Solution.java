package com.jasper.algs.leetcode.array.qu0539.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0539. 最小时间差
 * 
 * <p> 环形数组
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {

    	int size = timePoints.size();
    	
    	// 字符串 => 数字
		int[] tps = new int[size+1];
		for (int i = 0; i < size; i++) {
			tps[i] = Integer.parseInt(timePoints.get(i).substring(0, 2))*60 +
					Integer.parseInt(timePoints.get(i).substring(3, 5));
		}
		tps[size] = 24*60;// 简化时间差运算
		
		// 排序
		Arrays.sort(tps);
		tps[size] += tps[0];
		
		// 最小差
		int ans = tps[1]-tps[0];
		for (int i = 2; i <= size; i++) {
			ans = Math.min(ans, tps[i]-tps[i-1]);
		}
		
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 1
    	List<String> timePoints = new ArrayList<>();
    	timePoints.add("23:59");
    	timePoints.add("00:00");
    	
    	System.out.println(new Solution().findMinDifference(timePoints));
	}
}