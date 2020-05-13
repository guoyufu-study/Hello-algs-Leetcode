package com.jasper.algs.leetcode.bitmanipulation.qu0041.solu1;

/**
 * 0041. 缺失的第一个正数
 * 
 * <p> 1. 原地修改，正负号标识（推荐）
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
    	
    	int N = nums.length;
    	
    	// 判断是否包含1
    	boolean is1Exists = false;
    	for (int i = 0; i < N; i++) {
			if(nums[i]==1) {
				is1Exists = true;
				break;
			}
		}
    	if(!is1Exists) return 1; // 不包含，则1是缺失的第一个正数
    	
    	// 清理负数、0、大于数组长度的值
		for (int i = 0; i < N; i++) {
			if(nums[i]<=0 || nums[i]>N) 
				nums[i] = 1;
		}
		
		// 用(要检查的数字num-1)作为索引，
		// 值为负数表示数字存在，值为正数表示数字不存在
		for (int i = 0; i < N; i++) {
			// 将索引nums[i]-1对应的槽位，置为负数
			int index = nums[i] > 0? nums[i]-1: -nums[i]-1;
			if(nums[index] > 0) // 标示存在数字|nums[i]|
				nums[index] = -nums[index];
		}
		
		// 返回缺失的第一个正数
		for (int i = 0; i < N; i++) {
			if(nums[i]>0) 
				return i+1;
		}
		return N+1;
    }
    
    public static void main(String[] args) {
//		int[] nums = new int[] {1,2,3};
//		int[] nums = new int[] {0,1,2};
		int[] nums = new int[] {1,2,0};
		
		System.out.println(new Solution().firstMissingPositive(nums));
	}
}