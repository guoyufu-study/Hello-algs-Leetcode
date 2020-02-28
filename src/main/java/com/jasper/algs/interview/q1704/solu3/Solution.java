package com.jasper.algs.interview.q1704.solu3;

/**
 * 字典：先存再查
 */
public class Solution {

	public int missingNumber(int[] nums) {
		int[] dic = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) {//存字典
			dic[nums[i]] = 1;
		}
		
		int ans = -1;
		for (int i = 0; i < dic.length; i++) {//查字典
			if(dic[i]==0) {
				ans  = i;
				break;
			}
		}
		
		return ans;
    }
	
}
