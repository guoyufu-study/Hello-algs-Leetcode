package com.jasper.algs.contest.c191.qu5424.solu1;

/**
 * 5424. 数组中两元素的最大乘积
 *
 */
class Solution {
    public int maxProduct(int[] nums) {

    	int N = nums.length;
    	
    	int[] helper = new int[1001];
    	for (int i = 0; i < N; i++) {
			helper[nums[i]]++;
		}
    	
    	int first = 0;
    	int second = 0;
    	for (int i = 1001; i >=1; i--) {
			while(helper[i]>0) {
				helper[i]--;
				if(first==0) first=i;
				else if(second==0) {
					second=i;
					return (first-1) * (second-1);
				}
			}
		}
    	
    	return 0;
    }
}