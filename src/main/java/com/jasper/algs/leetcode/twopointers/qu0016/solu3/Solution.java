package com.jasper.algs.leetcode.twopointers.qu0016.solu3;

import java.util.Arrays;

/**
 * 排序+双指针(优化)
 */
public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		if(nums==null || nums.length<3) 
			throw new IllegalArgumentException("输入数组最少应有3个元素...");
		
		Arrays.sort(nums);//排序
        
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){//减少不必要的遍历
        	while(i>0 && i<nums.length-2 
        			&& nums[i] == nums[i-1])//去重
                i++;
        	
            int L = i+1;
            int R = nums.length - 1;
            while(L != R){
                int min = nums[i] + nums[L] + nums[L + 1];//最小和
                if(min > target ){
                    if(Math.abs(ans - target) > Math.abs(min - target))
                        ans = min;
                    break;
                }
                int max = nums[i] + nums[R] + nums[R - 1];//最大和
                if(target > max){
                    if(Math.abs(ans - target) > Math.abs(max - target))
                        ans = max;
                    break;  
                }
                
                int sum = nums[i] + nums[L] + nums[R];
                if(Math.abs(sum - target) < Math.abs(ans - target))//更新
                    ans = sum;
                // 判断三数之和是否等于target
                if(sum == target) return sum; //最接近值 target
                if(sum > target){//和大了
                    R--;
                    while(L != R && nums[R] == nums[R+1])
                        R--;
                }
                else{//和小了
                    L++;
                    while(L != R && nums[L] == nums[L-1])
                        L++;
                }
            }
        }
        return ans;
    }
}
