package com.jasper.algs.leetcode.dynamicprogramming.qu0152.solu3;

/**
 * 0152. 乘积最大子数组
 * 
 * <p>线性扫描
 */
class Solution {
    public int maxProduct(int[] nums) {
    	int leftcur = 1, max=Integer.MIN_VALUE;
    	// 左->右
        for (int num:nums){
            leftcur *= num;
            max = Math.max(max,leftcur);
            if(leftcur==0) leftcur=1;
        }
        
        // 右->左
        int rightcur=1;
        for(int i=nums.length-1;i>0;i--){
            rightcur *= nums[i];
            max = Math.max(max,rightcur);
            if(rightcur==0) rightcur=1;
        }
        return max;
    }
}