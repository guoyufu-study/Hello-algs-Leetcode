package com.jasper.algs.leetcode.backtracing.qu0401.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 */
class Solution {
	
	private static final int  N = 10;
    public List<String> readBinaryWatch(int num) {
    	List<String> ans = new ArrayList<String>();
    	
    	// 边界
    	if(num==0) {
    		ans.add("0:00");
    		return ans;
    	} else if(num >= 10) return ans;
    	
    	// 辅助数组：存二进制时间
    	int[] helper = new int[N];
    	
    	readBinaryWatch(ans, helper, -1, num);
    	
    	return ans;
    }

	private void readBinaryWatch(List<String> ans, int[] helper, int prev, int remnant) {
		// 终止
		if(remnant==0) {
			// 转换时间：时：分
			int hour = 0;
			for (int i = 9; i >= 6; i--) {
				hour = (hour<<1) + helper[i];
			}
			if(hour >= 12) return ; // 无效时间，忽略
			
			int second = 0;
			for (int i = 5; i >= 0; i--) {
				second = (second<<1) + helper[i];
			}
			if(second > 59) return ;//无效时间，忽略
			
			// 记录有效时间
			ans.add(hour + ":" + (second > 9 ? second : ("0"+second)));
			return ;
		}
			
			
		
		for (int i = prev+1; i < N-remnant+1; i++) {
			// 置1
			helper[i] = 1;
			
			// 下一位1
			readBinaryWatch(ans, helper, i, remnant-1);
			
			// 回溯 
			helper[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		int hour = 0;
		int[] helper = new int[] {
				1,1,1,1,
				1,1,1,1,1,1};
		for (int i = 0; i < 4; i++) {
			hour = (hour<<1) + helper[i];
		}
		
		int second = 0;
		for (int i = 4; i < 10; i++) {
			second = (second<<1) + helper[i];
		}
		
		System.out.println(second);
	}
}